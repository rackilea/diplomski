package com.sandbox;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Sandbox {

    public static void main(String argv[]) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(Sandbox.class.getResourceAsStream("/foo.xml"));

        NodeList nodeNodeList = document.getElementsByTagName("node");

        for (int i = 0; i < nodeNodeList.getLength(); i++) {

            Node nNode = nodeNodeList.item(i);

            System.out.println(nNode.getAttributes().getNamedItem("lat").getNodeValue());
            System.out.println(nNode.getAttributes().getNamedItem("lon").getNodeValue());

        }

    }


}