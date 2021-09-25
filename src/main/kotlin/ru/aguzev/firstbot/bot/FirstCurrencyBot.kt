package ru.aguzev.firstbot.bot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class FirstCurrencyBot : TelegramLongPollingBot() {

    @Value("\${telegram.botName}")
    private val botName: String = ""

    @Value("\${telegram.botToken}")
    private val botToken: String = ""

    override fun getBotToken(): String = botToken

    override fun getBotUsername(): String = botName

    override fun onUpdateReceived(update: Update?) {
        if (update != null) {
            if (!update.hasMessage()
                || !update.getMessage().isUserMessage()
                || !update.getMessage().hasText()
                || update.getMessage().getText().isEmpty())
                return
        }
        val incomingMessage = update?.message
        val chatId = incomingMessage?.chatId
        var responseMessage = SendMessage()
        responseMessage.chatId = chatId.toString()
        responseMessage.text = "Hello World!"
        //responseMessage.setParseMode("Markdown")
        execute(responseMessage)
    }

}
