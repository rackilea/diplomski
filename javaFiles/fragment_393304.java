package transformation;

import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformerTest {

    public static void main(String[] args) throws Exception {

        final String xmlSample = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><tag><nested>hello</nested></tag>";
        final String stylesheet = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:output method=\"xml\" version=\"1.0\" indent=\"yes\"/><xsl:template match=\"node()|@*\"><xsl:copy><xsl:apply-templates select=\"node()|@*\"/></xsl:copy></xsl:template></xsl:stylesheet>";

        final TransformerFactory factory = TransformerFactory.newInstance();

        final Source xslSource = new StreamSource(new StringReader(stylesheet));
        final Transformer transformer = factory.newTransformer(xslSource);

        final Source source = new StreamSource(new StringReader(xmlSample));
        final Result result = new StreamResult(System.out);

        transformer.transform(source, result);

    }

}