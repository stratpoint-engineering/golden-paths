# app

A Spring Boot 3 application following [Stratpoint Java Spring Boot Golden Path](https://engineering.stratpoint.io/backend/golden-paths/java-springboot).

## Tech Stack

| Layer | Technology | Version |
|---|---|---|
| Language | Java | 21 |
| Framework | Spring Boot | 3.3.x |
| Security | Spring Security + JWT | 6.x |
| ORM | Spring Data JPA / Hibernate | 6.x |
| Database | PostgreSQL | 16 |
| Migrations | Flyway | 10.x |
| Resilience | Resilience4j | 2.2.x |
| API Docs | SpringDoc OpenAPI | 2.5.x |
| Mapping | MapStruct | 1.5.x |
| Metrics | Micrometer + Prometheus | - |

## Prerequisites

- Java 21
- Maven 3.9+
- Docker & Docker Compose
- PostgreSQL 16 (or use Docker)

## Quick Start

```bash
# Clone the project
npx degit stratpoint-engineering/golden-paths/backend/java-springboot my-app
cd my-app

# Copy environment config
cp .env.example .env

# Run with Docker Compose
docker compose up -d

# Or run locally (requires PostgreSQL running)
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## API Documentation

When running locally, Swagger UI is available at:
- http://localhost:8080/swagger-ui.html

## Running Tests

```bash
# Unit tests
mvn test

# Integration tests (requires Docker for Testcontainers)
mvn verify

# With coverage report
mvn verify jacoco:report
# Report at: target/site/jacoco/index.html
```

## Project Structure

```
src/
├── main/
│   ├── java/com/company/app/
│   │   ├── config/          # Spring configuration
│   │   ├── controller/      # REST controllers (v1/)
│   │   │   └── advice/      # Global exception handler
│   │   ├── model/
│   │   │   ├── entity/      # JPA entities
│   │   │   ├── dto/         # Request/Response DTOs
│   │   │   └── mapper/      # MapStruct mappers
│   │   ├── repository/      # Spring Data repositories
│   │   ├── service/
│   │   │   ├── interfaces/  # Service contracts
│   │   │   └── impl/        # Service implementations
│   │   ├── exception/       # Custom exceptions
│   │   ├── security/        # JWT + Spring Security
│   │   └── util/            # Utility classes
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       ├── application-prod.yml
│       └── db/migration/    # Flyway migrations
└── test/
    └── java/com/company/app/
        ├── controller/      # MockMvc tests
        ├── service/         # Unit tests
        ├── repository/      # Testcontainers tests
        └── integration/     # Full integration tests
```

## Standards

Full standards and best practices: [Engineering Hub](https://engineering.stratpoint.io/backend/golden-paths/java-springboot)
