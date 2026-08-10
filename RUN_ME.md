# Run The Application

## Important

Local `.env.sample` values are intentionally dummy values. They are enough for
the application to start locally, run migrations, and test most non-provider
flows.

No real secrets are required for basic local startup. Real email sending and the
real Telegram bot flow require provider credentials.

## Prerequisites

- Docker
- Docker Compose
- Java 21
- Maven, or the included Maven wrapper

## Backend only: database + app

From `budgetapp`, first build the application JAR:

```bash
./mvnw clean package
```

On Windows PowerShell, use:

```powershell
.\mvnw.cmd clean package
```

Then start MySQL and the backend:

```bash
docker-compose --env-file .env.sample up --build
```

Backend URL:

```text
http://localhost:8081
```

Swagger/OpenAPI URL:

```text
http://localhost:8081/swagger-ui/index.html
```

Local limitations:

- `.env.sample` disables Telegram bot registration with `TELEGRAM_BOT_ENABLED=false`;
- Telegram login through the real bot needs `TELEGRAM_BOT_ENABLED=true` and a real `TELEGRAM_TOKEN`;
- email sending uses dummy Resend settings and requires real Resend credentials to work;
- production CORS/front-end URLs are represented by local placeholder values.

## Enable the real Telegram bot locally

Create a bot with BotFather using [BOTINSTRUCTION.md](BOTINSTRUCTION.md), then
set these values in `.env.sample` or in your own untracked env file:

```text
TELEGRAM_BOT_ENABLED=true
TELEGRAM_TOKEN=<real bot token>
```

## Stop all

From `budgetapp`:

```bash
docker-compose --env-file .env.sample down
```

## Stop all and delete database volume

From `budgetapp`:

```bash
docker-compose --env-file .env.sample down -v
```
