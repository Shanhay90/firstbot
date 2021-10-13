package ru.aguzev.firstbot.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.aguzev.firstbot.clients.CentralBankSoapClient
import ru.aguzev.firstbot.custommodel.ValuteCursOnDate

@Service
class CurrencyService(@Autowired val cbClient: CentralBankSoapClient) {

    fun getCurrencyByName(currencyName: String): ValuteCursOnDate {
        var currencies = cbClient.getCurrenciesRates()
        return currencies.first { currency -> currency.name.equals(currencyName) }
    }

    fun getCurrencyByNumericCode(numericCode: String): ValuteCursOnDate {
        var currencies = cbClient.getCurrenciesRates()
        return currencies.first { currency -> currency.numericCode.equals(numericCode) }
    }

    fun getCurrencyByLiteralCode(literalCode: String): ValuteCursOnDate {
        var currencies = cbClient.getCurrenciesRates()
        return currencies.first { currency -> currency.literalCode.equals(literalCode) }
    }
}
