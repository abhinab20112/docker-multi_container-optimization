# Docker Multi-Container Optimization

A Spring Boot-based backend project demonstrating **Docker optimization** and **multi-container orchestration** for fintech applications. This project focuses on building secure REST APIs, optimizing Docker images, and using multi-container setups with Docker Compose.

---

## Features

- Developed secure **REST APIs** with **Java** and **Spring Boot**.
- Implemented **JWT-based authentication** and **session management** for security.
- **Dockerfile Optimization**:
  - Reduced image size by **40%** (1.4GB → 838MB) using **multi-stage builds**.
  - Reduced build time by **48%**.
- **Multi-Container Application** using **Docker Compose**, accessible on the local network.
- **OTP Flood Prevention**:
  - Redis-based OTP rate limiting to prevent **100+ requests per minute** per user.
  - Applied **TTL** and **dormancy** concepts for secure OTP delivery.

---

## Tech Stack

- **Backend**: Java, Spring Boot, REST APIs  
- **Database**: PostgreSQL  
- **Containerization**: Docker, Docker Compose  
- **Caching / Rate Limiting**: Redis  

---

## Setup & Run
# Clone the repository
git clone https://github.com/abhinab20112/docker-multi_container-optimization.git
cd docker-multi_container-optimization

# Set environment variables (replace placeholders with your values)
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/jwt
export SPRING_DATASOURCE_USERNAME=your_db_user
export SPRING_DATASOURCE_PASSWORD=your_db_password
export JWT_SECRET=your_jwt_secret

# Build Docker images
docker-compose build

# Run containers
docker-compose up

# Open the application in your browser
# http://localhost:8081

