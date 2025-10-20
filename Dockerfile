# =========================
# Stage 1 — Build Thin JAR
# =========================
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy only pom.xml first to leverage Docker cache
COPY pom.xml .

# Pre-fetch dependencies (faster rebuilds if pom.xml unchanged)
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the thin JAR
RUN mvn clean package -DskipTests -Dthin

# =========================
# Stage 2 — Runtime
# =========================
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
