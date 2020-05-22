@XmlRootElement(namespace="test")
public class A {
   B b;
   String xmlFragment;

   @XmlAnyElement
   public Element getXmlFragment() {
       InputSource source = new InputSource(new StringReader(xmlFragment));
       Document doc = DocumentBuilderFactory.newInstance().parse(source);
       return doc.getDocumentElement();
   }
}