package forum9988170;

import java.io.File;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(DataBean.class);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        File xml = new File("src/forum9988170/input.xml");
        Document document = db.parse(xml);

        Binder<Node> binder = jc.createBinder();
        DataBean dataBean = (DataBean) binder.unmarshal(document);
        dataBean.setField2("NEW FIELD 2");
        dataBean.setField5("NEW FIELD 5");
        binder.updateXML(dataBean);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        t.transform(source, result);
    }

}