package com.unthreading.emojitoxml;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.OutputKeys;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class App {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        String str = "";
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = document.createElement("tag");
        document.appendChild(document.createProcessingInstruction(StreamResult.PI_DISABLE_OUTPUT_ESCAPING, "")); // <=== ADD THIS LINE
        root.appendChild(document.createTextNode(str));
        document.appendChild(root);
        document.appendChild(document.createProcessingInstruction(StreamResult.PI_ENABLE_OUTPUT_ESCAPING, "")); // <=== ADD THIS LINE
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(document), new StreamResult(new File("test.xml")));
    }
}