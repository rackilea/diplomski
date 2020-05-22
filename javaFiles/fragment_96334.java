import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


@Path("dom-api")
public class DomXmlResource {

    @GET
    @Produces("application/xml")
    public Response getXml() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();

        // create root element
        Element rootEl = doc.createElement("Model");
        doc.appendChild(rootEl);

        Model model = new Model();
        model.setProp("foo", "bar");
        model.setProp("name", "Paul");
        model.setValue("FooBar");

        // set static defined properties
        Element valueEl = doc.createElement("value");
        valueEl.appendChild(doc.createTextNode(model.getValue()));
        rootEl.appendChild(valueEl);

        // set dynamic properties
        for (Map.Entry<String, Object> entry: model.getProps().entrySet()) {
            Element dynamicEl = doc.createElement(entry.getKey());
            dynamicEl.appendChild(doc.createTextNode(String.valueOf(entry.getValue())));
            rootEl.appendChild(dynamicEl);
        }

        // return StreamingOutput so we can just stream the
        // XML results without having to store the String into memory.
        StreamingOutput entity = new StreamingOutput() {
            @Override
            public void write(OutputStream out)
                    throws IOException, WebApplicationException {
                try {
                    // write the XML structure to the output stream.
                    Transformer transformer = TransformerFactory.newInstance()
                            .newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    StreamResult result = new StreamResult(out);
                    DOMSource source = new DOMSource(doc);
                    transformer.transform(source, result);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        return Response.ok(entity).build();
    }

    public static class Model {
        private String value;
        private Map<String, Object> props = new HashMap<>();

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Map<String, Object> getProps() {
            return this.props;
        }

        public void setProp(String key, Object value) {
            this.props.put(key, value);
        }
    }
}