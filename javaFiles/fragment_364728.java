package com.example.tests.xml;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlDomTest
{
   private Document _target;

   @Before
   public void setUp() {
      final String xmlString = new String(
         "<Hospitals>\n" +
         "    <Hospital>\n" +
         "        <name>Hospital1</name>\n" +
         "        <tel-number>0272222222</tel-number>\n" +
         "    </Hospital>\n" +
         "    <Hospital>\n" +
         "        <name>Hospital2</name>\n" +
         "        <tel-number>0273333333</tel-number>\n" +
         "    </Hospital>\n" +
         "    <Hospital>\n" +
         "        <name>Hospital3</name>\n" +
         "        <tel-number>0270000000</tel-number>\n" +
         "    </Hospital>\n" +
         "</Hospitals>"
      );
      try ( // autoclose:
         StringReader reader = new StringReader(xmlString);
      ) {
         this._target = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(reader));
      } catch(final Exception e) {
         Assert.fail(e.getMessage());
      }
   }

   @After
   public void tearDown() {
      this._target = null;
   }

   @Test
   public void testReadDom(
   ) {
      final Node na = this._target.getElementsByTagName("Hospital").item(0);

      final NodeList nList1 = na.getChildNodes();

      final int index = this.getNodeIndex(nList1, "name");

      final Node nb = nList1.item(index);

      Assert.assertEquals("\n        ", nList1.item(0).getTextContent());

      final String hospitalName = nb.getTextContent();

      Assert.assertEquals("Hospital1", hospitalName);
   }

   private int getNodeIndex(final NodeList nList, final String nodeName) {
      for (int i = 0; i < nList.getLength(); i++) {
          if (nList.item(i).getNodeName().equals(nodeName)) {
            return i;
         }
      }

      return -1;
  }
}