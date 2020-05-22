import org.ccil.cowan.tagsoup.Parser;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;

public class MyDocumentBuilder extends DocumentBuilder {

    @Override
    public Document parse(InputSource inputSource) throws SAXException, IOException {

        XMLReader xmlReader = new Parser();
        xmlReader.setFeature(Parser.namespacesFeature, false);
        xmlReader.setFeature(Parser.namespacePrefixesFeature, false);

        try{
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMResult domResult = new DOMResult();
            transformer.transform(new SAXSource(xmlReader, inputSource), domResult);
            return (Document) domResult.getNode();
        }
        catch(Exception exp){
            throw new RuntimeException("Error parsing with Tagsoup");
        }
    }

    @Override
    public void setErrorHandler(ErrorHandler errorHandler) {

    }

    @Override
    public Document newDocument() {
        return null;
    }

    @Override
    public void setEntityResolver(EntityResolver entityResolver) {

    }

    @Override
    public boolean isValidating() {
        return false;
    }

    @Override
    public DOMImplementation getDOMImplementation() {
        return null;
    }

    @Override
    public boolean isNamespaceAware() {
        return false;
    }
}