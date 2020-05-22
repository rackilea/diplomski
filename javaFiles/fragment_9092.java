import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class CatalogTest {
   private static final String PATH_NAME = "Catalog.xml";



   public static void main(String[] args) {
      // comment one of the lines below and un-comment the other to test
      // marshallTest(); 
      unmarshallTest();
   }



   private static void unmarshallTest() {
      JAXBContext context;
      try {
         context = JAXBContext.newInstance(Catalog.class);
         Unmarshaller unmarshaller = context.createUnmarshaller();
         File catalogFile  = new File(PATH_NAME);
         Catalog catalog = (Catalog) unmarshaller.unmarshal(catalogFile  );
         System.out.println(catalog);
      } catch (JAXBException e) {
         e.printStackTrace();
      }

   }



   private static void marshallTest() {
      try {
         Book[] books = {
               new Book("bk101", "Smith, John", "Fubars Rule", 100.10, "2012-10-01", "A witty exposé"),
               new Book("bk102", "Python, Monty", "Your Hovercraft is full of Eels", 250.50, "10-01-01", "an even wittier exposé")
         };
         Catalog catalog = new Catalog();
         for (Book book : books) {
            catalog.addBook(book);
         }
         JAXBContext context = JAXBContext.newInstance(Catalog.class);
         Marshaller marshaller = context.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

         File catalogFile = new File(PATH_NAME);
         marshaller.marshal(catalog, catalogFile);

      } catch (JAXBException e) {
         e.printStackTrace();
      }
   }
}

@XmlRootElement
class Catalog {
   @XmlElement(name = "book")
   private List<Book> bookList = new ArrayList<Book>();

   public List<Book> getBookList() {
      return bookList;
   }

   public void addBook(Book book) {
      bookList.add(book);
   }

   @Override
   public String toString() {
      return "Catalog [bookList=" + bookList + "]";
   }


}

@XmlRootElement
@XmlType(propOrder = { "author", "title", "price", "date", "description"})
class Book {
   private String id;
   private String author;
   private String title;
   private double price;
   private String date;
   private String description;

   public Book() {
   }

   public Book(String id, String author, String title, double price,
         String date, String description) {
      this.id = id;
      this.author = author;
      this.title = title;
      this.price = price;
      this.date = date;
      this.description = description;
   }

   @XmlAttribute(name = "id")
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public String toString() {
      return "Book [id=" + id + ", author=" + author + ", title=" + title
            + ", price=" + price + ", date=" + date + ", description="
            + description + "]";
   }

}