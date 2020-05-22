import java.io.*;
import javax.microedition.io.*;
import net.rim.device.api.xml.parsers.*;
import org.w3c.dom.Document;

public class Test 
{

    public Document RetreiveXMLDocFromURL(String url) throws IOException
    {
        HttpConnection httpConn = (HttpConnection)Connector.open(url);
        int responseCode = httpConn.getResponseCode();
        Document xmlDoc = null;

        if (responseCode == HttpConnection.HTTP_OK)
        {
            try
            {
                InputStream inputStream = httpConn.openInputStream();
                DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                xmlDoc = docBuilder.parse(inputStream);                 
            }
            catch(Exception ex)
            {
                //error handling
            }                               
        }
        else        
        {
            //error handling
        }

        return xmlDoc;
    }
}