import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;



import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;




public class XMLParser {


     public void modifyDocument(String inputXml)
     {


                 try {
                     FileInputStream file = new FileInputStream(new File(inputXml));

                     DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

                     DocumentBuilder builder =  builderFactory.newDocumentBuilder();

                     Document xmlDocument = builder.parse(file);

                     XPath xPath =  XPathFactory.newInstance().newXPath();

                     String expression = "//operator[@class='k_medoids']/parameter[@key='k']";
                     String email = xPath.compile(expression).evaluate(xmlDocument);

                     NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

                     System.out.println(nodeList.getLength());
                     for (int i = 0; i < nodeList.getLength(); i++) {

                         NamedNodeMap attr = nodeList.item(i).getAttributes();
                        Node nodeAttr = attr.getNamedItem("value");
                        nodeAttr.setTextContent("VALUE TO CHANGE"); 
                     }

                  // write the content into xml file
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(xmlDocument);
                        StreamResult result = new StreamResult(new File(inputXml));
                        transformer.transform(source, result);              

                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (SAXException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 } catch (ParserConfigurationException e) {
                     e.printStackTrace();
                 } catch (XPathExpressionException e) {
                     e.printStackTrace();
                 } catch (TransformerConfigurationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }       
             }

}