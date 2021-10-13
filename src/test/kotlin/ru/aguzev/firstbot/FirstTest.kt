package ru.aguzev.firstbot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.w3c.dom.Node
import ru.aguzev.firstbot.clients.CentralBankSoapClient
import ru.aguzev.firstbot.custommodel.ValuteData
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@SpringBootTest
class FirstTest(
    @Autowired val client: CentralBankSoapClient,
) {

    @Test
    fun test() {

        client.getLatestDates()
    }

    @Test
    fun test11() {

        var node = client.getCursOnDateResponse().getCursOnDateResult.any as Node

        val jaxbContext: JAXBContext = JAXBContext.newInstance(ValuteData::class.java)
        val unmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        var valuteData = unmarshaller.unmarshal(node.firstChild) as ValuteData

        println(valuteData.cursOnDateList)
        val usdCourse = valuteData.cursOnDateList.filter { course -> course.literalCode.equals("USD") }.first()
        println("USD course is: " + usdCourse.course)
    }


}
