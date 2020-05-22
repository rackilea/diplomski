package org.example;

import java.io.*;
import java.util.logging.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.NodeIterator;
import org.apache.xalan.extensions.ExpressionContext;
import org.apache.xpath.XPathContext;
import org.apache.xpath.objects.XNodeSet;

public class XalanExtension {

    public static final String NS = "org:example:foo";

    public static final String XSLT = "" +
"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<xsl:stylesheet \n" +
"    xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"\n" +
"    xmlns:foo=\"org:example:foo\"\n" +
"    xmlns:fun=\"xalan://org.example.XalanExtension\"\n" +
"    version=\"1.0\"> \n" +
"    \n" +
"    <xsl:template match=\"*|@*\">\n" +
"        <xsl:apply-templates select=\"*|@*\"/>\n" +
"    </xsl:template>\n" +
"    \n" +
"    <xsl:template match=\"foo:test\">\n" +
"       <xsl:variable name=\"result\" select=\"fun:evaluate(.)\"/>\n" +
"        <xsl:message>\n" +
"            Test: <xsl:value-of select=\".\"/> Result: <xsl:value-of select=\"$result\"/>\n" +
"        </xsl:message>\n" +
"    </xsl:template>\n" +
"    \n" +
"</xsl:stylesheet>";

    public static final String XML = "" +
"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<tests xmlns=\"org:example:foo\">\n" +
"   <a>1</a>\n" +
"   <b>2</b>\n" +
"   <c>3</c>\n" +
"   <test>../foo:a &gt; 5</test>\n" +
"</tests>";

    private TransformerFactory xalanTransFact;

    public XalanExtension() {
        xalanTransFact = new org.apache.xalan.processor.TransformerFactoryImpl();
    }

    public void transform() {
        try {
            StringWriter writer;

            writer = new StringWriter();

            System.out.println(org.apache.xalan.Version.getVersion());

            Transformer transformer = xalanTransFact.newTransformer(new StreamSource(new StringReader(XSLT)));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "text");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            transformer.transform(
                    new StreamSource(new StringReader(XML)),
                    new StreamResult(writer));

            System.out.println(writer.toString());
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XalanExtension.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XalanExtension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        XalanExtension instance = new XalanExtension();
        instance.transform();
    }

    public static final Object evaluate(ExpressionContext myContext, NodeIterator nodes) {
        if (myContext instanceof XPathContext.XPathExpressionContext) {
            XPathContext xctxt = null;
            Node node = nodes.nextNode();
            if (node != null && node.hasChildNodes()) {
                String xpathExpr = node.getFirstChild().getNodeValue();
                try {
                    xctxt = ((XPathContext.XPathExpressionContext) myContext).getXPathContext();
                    org.apache.xpath.XPath dynamicXPath = new org.apache.xpath.XPath(xpathExpr, xctxt.getSAXLocator(),
                            xctxt.getNamespaceContext(),
                            org.apache.xpath.XPath.SELECT);

                    return dynamicXPath.execute(xctxt, myContext.getContextNode(), xctxt.getNamespaceContext());
                } catch (TransformerException e) {
                    return new XNodeSet(xctxt.getDTMManager());
                }
            }
        }
        return null;
    }
}