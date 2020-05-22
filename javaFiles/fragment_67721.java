import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class NestedCDATA {

    private static String response = 
        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
        "  <s:Body>" +
        "    <GetIMEIInfoResponse xmlns=\"http://tempuri.org/\">" +
        "      <GetIMEIInfoResult>" +
        "        <![CDATA[" +
        "        <SerialsDetail>" +
        "          <Item>" +
        "            <ResponseCode>2</ResponseCode>" +
        "            <Remark>Aawwwwwwww yeaaaah!</Remark>" +
        "          </Item>" +
        "        </SerialsDetail>" +
        "        ]]>" +
        "      </GetIMEIInfoResult>" +
        "    </GetIMEIInfoResponse>" +
        "  </s:Body>" +
        "</s:Envelope>";

    public static String getCdata(Node parent) {
        NodeList cs = parent.getChildNodes();
        for(int i = 0; i < cs.getLength(); i++){
            Node c = cs.item(i);
            if(c instanceof CharacterData) {
                CharacterData cdata = (CharacterData)c;
                String content = cdata.getData().trim();
                if (content.length() > 0) {
                  return content;
                }
            }
        }
        return "";
    }


    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response)));
            Node cdataParent = doc.getElementsByTagName("GetIMEIInfoResult").item(0);
            DocumentBuilder cdataBuilder = factory.newDocumentBuilder();
            Document cdataDoc = cdataBuilder.parse(new InputSource(new StringReader(
              getCdata(cdataParent)
            )));
            Node remark = cdataDoc.getElementsByTagName("Remark").item(0);
            System.out.println("Content of Remark in CDATA: " + getCdata(remark));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}