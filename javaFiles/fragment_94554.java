package test;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TestService {

    @WebMethod
    public RequestStatus setReferenceData(ReferenceDataSetList refData) {
        return new RequestStatus(Result.FAILURE);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8084/service", new TestService());
    }

}