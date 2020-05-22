import java.io.FileWriter;
import com.megginson.sax.XMLWriter;
import org.xml.sax.helpers.AttributesImpl;

public class GenerateXML
{

    public static void main (String args[])
    throws Exception
    {
    XMLWriter writer = new XMLWriter(new FileWriter("output.xml"));

    writer.startDocument();
    writer.startElement("","ingredients","",null);
    for (String ingredient : ingredients) {
        AttributesImpl attribs = new AttributesImpl();
        attribs.addAttribute("","name","","",ingredient);
        writer.startElement("", "ingredient","",attribs);
        writer.endElement("ingredient");
    }
    writer.endElement("ingredients");
    writer.endDocument();
}