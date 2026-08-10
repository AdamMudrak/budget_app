# Setting Up a Telegram Bot with BotFather

Local startup does not require a real Telegram bot. The provided `.env.sample`
disables Telegram registration with:

```text
TELEGRAM_BOT_ENABLED=false
```

Use this guide only when you want to test the real Telegram login flow.

## Step 1: Start a chat with BotFather

1. Open Telegram and search for **BotFather**, or open <https://t.me/BotFather>.
2. Start the conversation.

## Step 2: Create a new bot

Send:

```text
/newbot
```

BotFather will ask for:

- bot name, for example `MonetaBot`;
- bot username, which must be unique and end with `bot`, for example
  `MonetaFinanceBot`.

After creation, BotFather will provide an API token. Store it securely and do
not commit it.

## Step 3: Set commands

Send:

```text
/setcommands
```

Select your bot and enter:

```text
start - Start the bot
stop - Stop the bot
```

## Step 4: Enable the bot in the app

Set these environment variables:

```text
TELEGRAM_BOT_ENABLED=true
TELEGRAM_TOKEN=<real bot token>
```

For normal local development without Telegram, leave:

```text
TELEGRAM_BOT_ENABLED=false
TELEGRAM_TOKEN=local-telegram-token
```
