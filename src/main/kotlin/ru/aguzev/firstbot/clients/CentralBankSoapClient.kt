package ru.aguzev.firstbot.clients

import org.springframework.stereotype.Service
import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import ru.aguzev.firstbot.soapmodel.GetLatestDate
import ru.aguzev.firstbot.soapmodel.GetLatestDateResponse

@Service
class CentralBankSoapClient : WebServiceGatewaySupport() {

    fun getLatestDates(): GetLatestDateResponse {
        val request = GetLatestDate()
        return webServiceTemplate.marshalSendAndReceive(request) as GetLatestDateResponse
    }


}
