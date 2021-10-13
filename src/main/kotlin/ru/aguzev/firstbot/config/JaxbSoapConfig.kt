package ru.aguzev.firstbot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory
import ru.aguzev.firstbot.clients.CentralBankSoapClient
import javax.xml.bind.Marshaller
import javax.xml.soap.MessageFactory
import javax.xml.soap.SOAPConstants


@Configuration
class JaxbSoapConfig {

    @Bean
    fun marshaller(): Jaxb2Marshaller {
        val marshaller = Jaxb2Marshaller()
        var prop = mapOf(Marshaller.JAXB_ENCODING to "ISO-8859-1" )
        //marshaller.setUnmarshallerProperties(prop)
        marshaller.setMarshallerProperties(prop)
        marshaller.setPackagesToScan("ru.aguzev.firstbot.soapmodel")
        return marshaller
    }

    @Bean
    fun cbSoapClient(marshaller: Jaxb2Marshaller): CentralBankSoapClient {
        val msgFactory: MessageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL)
        val saajSoapMessageFactory = SaajSoapMessageFactory(msgFactory)
        val client = CentralBankSoapClient(saajSoapMessageFactory)
        client.defaultUri = "http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx"
        client.marshaller = marshaller
        client.unmarshaller = marshaller
        return client
    }

}
