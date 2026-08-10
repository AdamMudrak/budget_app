package com.example.budgetingapp.telegramregistrationbot;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotRegister {
    private final BudgetAppBot budgetAppBot;
    private final boolean telegramBotEnabled;

    public BotRegister(BudgetAppBot budgetAppBot,
                       @Value("${telegram.bot.enabled}") boolean telegramBotEnabled) {
        this.budgetAppBot = budgetAppBot;
        this.telegramBotEnabled = telegramBotEnabled;
    }

    @PostConstruct
    public void init() throws TelegramApiException {
        if (!telegramBotEnabled) {
            return;
        }
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(budgetAppBot);
    }
}
