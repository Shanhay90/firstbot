package ru.aguzev.firstbot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import ru.aguzev.firstbot.clients.CentralBankSoapClient


@Configuration
class JaxbSoapConfig {

    @Bean
    fun marshaller(): Jaxb2Marshaller? {
        val marshaller = Jaxb2Marshaller()
        marshaller.setPackagesToScan("ru.aguzev.firstbot.**")
        return marshaller
    }

    @Bean
    fun cbSoapClient(marshaller: Jaxb2Marshaller?): CentralBankSoapClient? {
        val client = CentralBankSoapClient()
        client.defaultUri = "http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx"
        client.marshaller = marshaller
        client.unmarshaller = marshaller
        return client
    }
}
