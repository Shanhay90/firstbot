package ru.aguzev.firstbot.clients

import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory
import org.w3c.dom.Node
import ru.aguzev.firstbot.custommodel.ValuteCursOnDate
import ru.aguzev.firstbot.custommodel.ValuteData
import ru.aguzev.firstbot.soapmodel.*
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller


class CentralBankSoapClient(saajSoapMessageFactory: SaajSoapMessageFactory) :
    WebServiceGatewaySupport(saajSoapMessageFactory) {

    fun getLatestDates(): GetLatestDateTimeResponse {
        return webServiceTemplate.marshalSendAndReceive(GetLatestDateTime()) as GetLatestDateTimeResponse
    }

    fun getCursOnDateResponse(): GetCursOnDateResponse {
        var request = GetCursOnDate()
        request.onDate = getLatestDates().getLatestDateTimeResult
        return webServiceTemplate.marshalSendAndReceive(request) as GetCursOnDateResponse
    }

    fun getCurrenciesRates(): List<ValuteCursOnDate> {
        // TODO search way to parse '<<diffgr:diffgram>.....</diffgr:diffgram>'
        val coursesOnDateNode = getCursOnDateResponse().getCursOnDateResult.any as Node
        val jaxbContext: JAXBContext = JAXBContext.newInstance(ValuteData::class.java)
        val unmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        val valuteData = unmarshaller.unmarshal(coursesOnDateNode.firstChild) as ValuteData
        return valuteData.cursOnDateList
    }
}
