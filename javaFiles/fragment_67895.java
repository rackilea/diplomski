package com.stackoverflow;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Question6855476 {
private static final String CFG_XML_PATH = "D:\\sample\\path\\question6855476.xml";
private static final String searchArg = "ABC";

public static void main(String[] args) {

    List locList = getLocsByCategoryName(searchArg);
    List linkList = getLinksByCategoryName(searchArg);

    printCollection(locList,"LOC");
    printCollection(linkList,"LINKS");

}

private static void printCollection(List locList, String string) {
    System.out.println();
    System.out.println("### Collection: "+string+"\n");
    if(locList.isEmpty()) {
        System.out.println("\tNo items. Collection is empty.");
    } else {
        for(Object obj: locList) {
            System.out.println("\t"+obj);
        }
    }

}

private static List getLocsByCategoryName(String catName) {
    if(null==catName||catName.length()<=0) {
        System.out.println("ERROR: catName is null/blank");
        return Collections.EMPTY_LIST;
    } else {
        return getSubcatAttrValuesByAttrName("loc", catName);
    }
}

private static List getLinksByCategoryName(String catName) {
    if(null==catName||catName.length()<=0) {
        System.out.println("ERROR: catName is null/blank");
        return Collections.EMPTY_LIST;
    } else {
        return getSubcatAttrValuesByAttrName("link", catName);
    }
}

private static List<Object> getSubcatAttrValuesByAttrName(String attrName, String catName) {

    List<Object> list = new ArrayList<Object>();

    if(null==attrName||attrName.length()<=0) {
        System.out.println("ERROR: attrName is null/blank");
    } else {
        try {
              File file = new File(CFG_XML_PATH);
              DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
              DocumentBuilder db = dbf.newDocumentBuilder();
              Document doc = db.parse(file);
              doc.getDocumentElement().normalize();

              NodeList catLst = doc.getElementsByTagName("category");

              for (int i = 0; i < catLst.getLength(); i++) {

                  Node cat = catLst.item(i);

                  NamedNodeMap catAttrMap = cat.getAttributes();
                  Node catAttr = catAttrMap.getNamedItem("name");

                  if(catName.equals(catAttr.getNodeValue())){ // CLUE!!!

                      NodeList subcatLst = cat.getChildNodes();

                      for (int j = 0; j < subcatLst.getLength(); j++) {
                          Node subcat = subcatLst.item(j);
                          NamedNodeMap subcatAttrMap = subcat.getAttributes();

                          if(subcatAttrMap!=null) {
                              Node subcatAttr = subcatAttrMap.getNamedItem(attrName);
                              list.add(subcatAttr.getNodeValue());
                          }
                      }
                  }
              }
        } catch (Exception e) { // FIXME
            e.printStackTrace();
        }
    }
    return list;
}