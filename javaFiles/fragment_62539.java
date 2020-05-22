import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nerdforge.unxml.Parsing;
import com.nerdforge.unxml.factory.ParsingFactory;
import com.nerdforge.unxml.parsers.Parser;
import org.w3c.dom.Document;

public class XmlParser {
    public ObjectNode parseXml(String inputXml){
        Parsing parsing = ParsingFactory.getInstance().create();
        Document document = parsing.xml().document(inputXml);

        Parser<ObjectNode> parser = parsing.obj("root")
            .attribute("flow")
            .attribute("handler",  "handler", parsing.obj()
                .attribute("price", "price", parsing.number())
                .attribute("item")
                .attribute("value", "VALUE", parsing.with(Integer::parseInt))
            )
            .build();

        ObjectNode result = parser.apply(document);
        return result;
    }
}