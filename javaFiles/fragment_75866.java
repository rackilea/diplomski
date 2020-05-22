package forum11620825;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Book_QNAME = new QName("", "book");

    public ObjectFactory() {
    }

    public BooksList createBooksList() {
        return new BooksList();
    }

    public BookType createBookType() {
        return new BookType();
    }

    @XmlElementDecl(namespace = "", name = "book")
    public JAXBElement<BookType> createBook(BookType value) {
        return new JAXBElement<BookType>(_Book_QNAME, BookType.class, null, value);
    }

}