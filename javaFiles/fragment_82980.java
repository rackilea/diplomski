import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;

public class Test {

    public static void main(String[] args) throws Exception {
        String soapIn = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "   <soapenv:Header />\n" +
                "   <soapenv:Body>\n" +
                "      <ns:getChannelLineupInfoResponse xmlns:ns=\"http://channellineup.services.vidctlwhse.oss.cable.comcast.com/xsd\">\n" +
                "          <ns:return>\n" +
                "              <?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "              <response rows=\"1044\" type=\"success\">\n" +
                "              </response>\n" +
                "          </ns:return>\n" +
                "      </ns:getChannelLineupInfoResponse>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        System.out.println("InneoquestSoapHandler.createNewSoapResponse: about to createMessage...");
        SOAPMessage newMsg = messageFactory.createMessage(
                                new MimeHeaders(),
                                new ByteArrayInputStream(soapIn.getBytes(Charset.forName("UTF-8"))));
        System.out.println("InneoquestSoapHandler.createNewSoapResponse: about to get new envelope...");
        SOAPEnvelope newEnv = newMsg.getSOAPPart().getEnvelope();  //fails here
        System.out.println("InneoquestSoapHandler.createNewSoapResponse: about to get old envelope...");
        newMsg.writeTo(System.out);
        System.out.println("**");
        System.out.println("Envolope " + newEnv);
    }
}