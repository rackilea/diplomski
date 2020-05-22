import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Test {

  public static void main(String[] args) throws Exception {
    Document document = new SAXBuilder().build(Test.class.getResourceAsStream("test.xml"));

    for(Element elt :document.getRootElement().getChildren()) {
      System.out.println("tag : "+elt.getName());
      System.out.println("value : " + elt.getText()+"\n");
    }
  }
}