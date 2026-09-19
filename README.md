# Java Banking Microservices

Educational banking platform built with Java 21, Spring Boot, PostgreSQL, Kafka, Docker Compose, and JWT-based authentication.

## Architecture

- `account-service`: customer and account management.
- `transaction-service`: deposits, withdrawals, transfers, and transaction history.
- `api-gateway`: single entry point for future routing and authentication.
- `shared`: common domain contracts and utilities.

## Current scope

This repository is designed for learning microservices, REST APIs, persistence, validation, messaging, and security. It is not production banking software and must not process real customer funds.

## Requirements

- Java 21+
- Maven 3.9+
- Docker and Docker Compose

## Run dependencies

```bash
docker compose up -d postgres kafka
```

Run each service from its directory with `./mvnw spring-boot:run` or `mvn spring-boot:run`.

## Main endpoints

### Account service

- `POST /api/customers`
- `GET /api/customers/{id}`
- `POST /api/accounts`
- `GET /api/accounts/{id}`

### Transaction service

- `POST /api/transactions/deposit`
- `POST /api/transactions/withdraw`
- `POST /api/transactions/transfer`
- `GET /api/transactions/account/{accountId}`

## Design decisions

- Monetary values use `BigDecimal`.
- State-changing operations are transactional.
- Business errors use structured JSON responses.
- Services own their data and communicate through HTTP/events.
- Secrets are supplied through environment variables.

## Disclaimer

Educational project only. It does not implement the regulatory, operational, security, auditing, resilience, and compliance requirements of a real financial institution.
