package com.loknath.lab;


/*
*@Author Loknath 
*/

 import java.io.FileNotFoundException;
 import java.util.ArrayList;
 import org.jsoup.Jsoup;
 import org.jsoup.nodes.Document;
 import org.jsoup.nodes.Element;
 import org.jsoup.parser.Tag;
 import org.jsoup.select.Elements;

 public class Test {

public static void main(String[] args) {
    ArrayList list = new ArrayList();
    Test test = new Test();
    String file = "OCtest.txt";
    try {
        list = test.entityExtractionByFile(file);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(list);
}

public ArrayList entityExtractionByFile(String fileLocation)
        throws FileNotFoundException {
    String content;
    ArrayList list = new ArrayList();
    // You may want to change to sth else to read in the file as string
    FileToString fileIn = new FileToString();
    content = fileIn.convertFile(fileLocation);

    Document doc = Jsoup.parse(content);

    Element element = doc.select("CalaisSimpleOutputFormat").first();
    Elements divChildren = element.children();

    Elements detachedDivChildren = new Elements();
    for (Element elem : divChildren) {
        Element detachedChild = new Element(Tag.valueOf(elem.tagName()),
                elem.baseUri(), elem.attributes().clone());
        detachedDivChildren.add(detachedChild);
    }
    for (Element elem : divChildren) {

        list.add(elem.ownText());
        System.out.println(elem.ownText());

    }
    return list;
}
}