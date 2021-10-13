package ru.aguzev.firstbot

enum class Currency(val currencyName: String, val literalCode: String, val numericCode: String) {
    USD("Доллар США", "USD", "840"),
    EUR("Евро", "EUR", "978"),
    GBP("Фунт стерлингов Соединенного королевства", "GBP", "826")
}
