import com.thoughtworks.xstream.XStream;

public class XStreamTest {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.processAnnotations(Myclass1.class);
        xStream.processAnnotations(Myclass2.class);
        xStream.processAnnotations(Myclass3.class);

        Object fromXML = xStream.fromXML(XStreamTest.class.getResourceAsStream("source.xml"));
        System.out.println(fromXML);
    }
}