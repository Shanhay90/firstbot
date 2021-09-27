package ru.aguzev.firstbot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.aguzev.firstbot.clients.CentralBankSoapClient

@SpringBootTest
class FirstTest(@Autowired val client: CentralBankSoapClient) {

    @Test
    fun test(){

        client.getLatestDates()
    }



}
