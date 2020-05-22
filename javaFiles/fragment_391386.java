import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//. . .
public class MyXmlHandler extends DefaultHandler
{
    @Override
    public void startDocument()
    {
        Log.i(TAG,"Starting to parse document.");
    }
    @Override
    public void endDocument()
    {
            Log.i(TAG,"End of document.");
    }
    @Override
    public void startElement(String uri,String localName,String qName,Attributes attributes)
    {
        if(localName.equals("myxmltag"))
        {
                 //do something with myxmltag and attributes.
        }
    }    
}    
public void parseDocument()
{
    try {
         URL myxmlUri = new URL("file:///sdcard/appfolder/myxmldoc.xml");
         SAXParserFactory spf = SAXParserFactory.newInstance();
         SAXParser sp = spf.newSAXParser();
         XMLReader xr = sp.getXMLReader();
         MyXmlHandler myxmlhandler = new MyXmlHandler();
         xr.setContentHandler(myxmlhandler);
         InputSource inputs = new InputSource(myxmlUri.openStream());
         xr.parse(inputs);
         // . . .