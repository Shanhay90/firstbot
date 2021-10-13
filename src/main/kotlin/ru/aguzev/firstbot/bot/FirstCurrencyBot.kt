package ru.aguzev.firstbot.bot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import ru.aguzev.firstbot.Currency
import ru.aguzev.firstbot.services.CurrencyService

@Service
class FirstCurrencyBot(private val currencyService: CurrencyService) : TelegramLongPollingBot() {

    @Value("\${telegram.botName}")
    private val botName: String = ""

    @Value("\${telegram.botToken}")
    private val botToken: String = ""

    override fun getBotToken(): String = botToken

    override fun getBotUsername(): String = botName

    override fun onUpdateReceived(update: Update) {
        if (unsupportableUpdate(update)) return
        val incomingMessage = update.message
        val chatId = incomingMessage.chatId
        val text = incomingMessage.text

        var responseMessage = SendMessage()
        responseMessage.chatId = chatId.toString()



        when (text) {
            "/start" -> {
                responseMessage.text = "Введите буквенный код валюты\n (Поддерживаются: 'USD', 'EUR', 'GBP')"
            }
            in Currency.values().map(Currency::literalCode) -> {
                var messageText = "Текущий курс ${text}:\n"
                messageText += currencyService.getCurrencyByLiteralCode(text).course
                messageText += " руб."
                responseMessage.text = messageText
            }
            else -> {
                responseMessage.text = "Введите буквенный код валюты\n (Поддерживаются: 'USD', 'EUR', 'GBP')"
            }
        }
        execute(responseMessage)
    }

    private fun unsupportableUpdate(update: Update): Boolean {
        return !update.hasMessage()
                || !update.getMessage().isUserMessage()
                || !update.getMessage().hasText()
                || update.getMessage().getText().isEmpty()
    }
}
