@Component
public class MockWS implements IMockWS {

    @Override
    public String callSoapClient() throws JAXBException{
        return "CallSoapCl";
    }
}