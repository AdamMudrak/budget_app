# Moneta BudgetApp Backend

Backend API for a personal budgeting application. The application covers user
registration and authentication, financial accounts, income and expense
transactions, transfers, budgets, savings targets, category management, support
requests, Telegram-assisted login, email flows, and Swagger/OpenAPI
documentation.

## Core functionality

- Authentication and user flows:
  - email registration and login;
  - Telegram login flow;
  - JWT-based access/refresh/action tokens;
  - password change and password reset.
- Finance tracking:
  - income and expense transactions;
  - transaction filtering by account, date range, and categories;
  - chart endpoints grouped by days, months, and years.
- Account management:
  - create, update, and retrieve accounts;
  - default account selection.
- Category management:
  - income categories;
  - expense categories.
- Transfers, targets, and budgets:
  - transfer funds between accounts;
  - create and replenish savings targets;
  - create and delete category budgets.
- Support:
  - public support request endpoint that forwards messages by email.

## Technology stack

- Java 21
- Spring Boot 3.4.4
- Spring Web MVC
- Spring Security
- Spring Data JPA / Hibernate
- MySQL 8.4 in Docker Compose
- Liquibase
- Maven
- Lombok
- MapStruct
- Bean Validation
- Springdoc OpenAPI / Swagger UI
- JWT (`jjwt`)
- Resend Java SDK
- TelegramBots
- Log4j 2
- Docker / Docker Compose

## API documentation

Swagger UI is available locally at:

- <http://localhost:8081/swagger-ui/index.html>

OpenAPI JSON is available locally at:

- <http://localhost:8081/v3/api-docs>

The local environment uses dummy secrets by default. It is intended for local
startup, schema validation, Swagger exploration, and non-provider development
flows.

Email delivery and the real Telegram bot flow require real provider credentials.
The app can still start locally without those secrets.

## Local startup

See [RUN_ME.md](RUN_ME.md) for the exact local commands.

Short version:

```bash
./mvnw clean package
docker-compose --env-file .env.sample up --build
```

Backend URL:

```text
http://localhost:8081
```

## Telegram bot setup

The local `.env.sample` disables Telegram bot registration with
`TELEGRAM_BOT_ENABLED=false`. To enable the real bot flow, create a bot and set
`TELEGRAM_BOT_ENABLED=true` plus a real `TELEGRAM_TOKEN`.

See [BOTINSTRUCTION.md](BOTINSTRUCTION.md).

## License

This project is proprietary. Copyright and all rights are reserved by Adam
Mudrak, resident of Ukraine.

See [LICENSE.md](LICENSE.md) for permitted educational use and usage restrictions.
