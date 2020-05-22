package forum11620825;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("forum11620825");
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        File input1 = new File("src/forum11620825/booksList.xml");
        BooksList bookList = (BooksList) unmarshaller.unmarshal(input1);

        File input2 = new File("src/forum11620825/book.xml");
        JAXBElement<BookType> je = (JAXBElement<BookType>) unmarshaller.unmarshal(input2);
        BookType bookType = je.getValue();
    }

}