import java.io.IOException;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;

public class JDomFlatten {

@Test
public void testFlatten() {
    final String xml = "<grandparent name=\"grandpa bob\">"//
            + "<parent name=\"papa john\">"//
            + "<children>"//
            + "<child name=\"mark\" />"//
            + "<child name=\"cindy\" />"//
            + "</children>"//
            + "</parent>"//
            + "<parent name=\"papa henry\">"// 
            + "<children>" //
            + "<child name=\"mary\" />"//
            + "</children>"//
            + "</parent>" //
            + "</grandparent>";
    final StringReader stringReader = new StringReader(xml);
    final SAXBuilder builder = new SAXBuilder();
    try {
        final Document document = builder.build(stringReader);
        final Element grandparentElement = document.getRootElement();
        final StringBuilder outString = new StringBuilder();
        for (final Object parentElementObject : grandparentElement.getChildren()) {
            final Element parentElement = (Element) parentElementObject;
            for (final Object childrenElementObject : parentElement.getChildren()) {
                final Element childrenElement = (Element) childrenElementObject;
                for (final Object childElementObject : childrenElement.getChildren()) {
                    final Element childElement = (Element) childElementObject;

                    outString.append(grandparentElement.getAttributeValue("name"));
                    outString.append(" ");
                    outString.append(parentElement.getAttributeValue("name"));
                    outString.append(" ");
                    outString.append(childElement.getAttributeValue("name"));
                    outString.append("\n");
                }
            }

        }
        System.out.println(outString);

    } catch (final JDOMException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (final IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}