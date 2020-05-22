package com.hum;

import java.io.InputStreamReader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author herve
 */
public class PrintNameXML
{
  public static void main(String[] args) throws Exception
  {
    String xml = "<a><o><u>ok</u></o></a>";
    Document doc = 
     DocumentBuilderFactory
     .newInstance()
     .newDocumentBuilder()
     .parse(new InputSource(new StringReader(xml)));
    NodeList nl = doc.getElementsByTagName("*");
    for (int i = 0; i < nl.getLength(); i++)
    {
      System.out.println("name is : "+nl.item(i).getNodeName());
    }
  }
}