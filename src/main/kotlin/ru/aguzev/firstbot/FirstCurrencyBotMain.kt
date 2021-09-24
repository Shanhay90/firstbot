package ru.aguzev.firstbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FirstCurrencyBotMain

fun main(args: Array<String>) {
    runApplication<FirstCurrencyBotMain>(*args)
}

