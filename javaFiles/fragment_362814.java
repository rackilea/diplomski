import java.io.IOException;
import org.junit.Test;
import org.xmlbeam.XBProjector;
import org.xmlbeam.annotation.XBDocURL;
import org.xmlbeam.annotation.XBRead;

public class TestNodeContains {

@XBDocURL("resource://book.xml")
public interface Books {

    @XBRead("//verse[contains(text(),'{0}')]")
    String lookup(String string);

}

@Test
public void testXpathContains() throws IOException {
    Books books = new XBProjector().io().fromURLAnnotation(Books.class);
    System.out.println(books.lookup("word"));

}
}