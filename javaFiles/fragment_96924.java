import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import java.io.StringReader;
....   
String inputStr = "<rootnode></rootnode>";
Element e = new Element("parentnode");
StringReader stringReader = new StringReader(inputStr);
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(stringReader);
Element rootE = doc.getRootElement();
e.addContent(rootE.detach());  // <== Add an Element rather than a String