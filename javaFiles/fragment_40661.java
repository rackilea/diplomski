import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class StringAdapter extends XmlAdapter<Object, String> {

    private Document document;

    @Override
    public String unmarshal(Object v) throws Exception {
    Element element = (Element) v;
    return element.getTagName();
    }

    @Override
    public Object marshal(String v) throws Exception {
    return getDocument().createElement(v);
    }

    private Document getDocument() throws Exception {
    if(null == document) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.newDocument();
    }
    return document;
    }

}