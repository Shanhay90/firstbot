package ru.aguzev.firstbot.clients

import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory
import ru.aguzev.firstbot.soapmodel.GetLatestDate
import ru.aguzev.firstbot.soapmodel.GetLatestDateResponse


class CentralBankSoapClient(saajSoapMessageFactory: SaajSoapMessageFactory) :
    WebServiceGatewaySupport(saajSoapMessageFactory) {

    fun getLatestDates(): GetLatestDateResponse {
        return webServiceTemplate.marshalSendAndReceive(GetLatestDate()) as GetLatestDateResponse
    }


}
