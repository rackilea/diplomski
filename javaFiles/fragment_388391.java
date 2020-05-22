import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Stock {
private LinkedList<Book> books;
public Stock(){
  books=new LinkedList<>();
}

public static void main(String a[]){ 
    Stock myStock = new Stock();
    myStock.loadBookDetails ();
    System.out.println("Unsorted list entries: ");
    for(Book b:myStock.books){
        System.out.println(b);
    }
    Collections.sort(myStock.books,new MyTitleComp());
    System.out.println("Sorted list entries: ");
    for(Book b:myStock.books){
        System.out.println(b);
    }
}
public void loadBookDetails (){
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\manna\\desktop\\testing.txt")))
        {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[]details = currentLine.split(":");
                books.add(new Book(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]),Integer.parseInt(details[5])));
            }

        } catch (IOException e) {
                e.printStackTrace();
        } 
 }

 }

 class MyPriceComp implements Comparator<Book>{

@Override
public int compare(Book book1, Book book2) {
    if( book1.getPrice()< book2.getPrice()){
        return 1;
    } else {
        return -1;
    }
 }
 }

 class MyTitleComp implements Comparator<Book>{

 @Override
 public int compare(Book book1, Book book2) {
    return book1.getTitle().compareToIgnoreCase(book2.getTitle());
}
}

class Book{

private String author, title,edition, publisher;
private int price, quantity;

public Book(String author, String title, String edition, String publisher, int price, int quantity) {
    this.author = author;
    this.title = title;
    this.edition = edition;
    this.publisher = publisher;
    this.price = price;
    this.quantity = quantity;
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

public String getEdition() {
    return edition;
}

public void setEdition(String edition) {
    this.edition = edition;
}

public String getPublisher() {
    return publisher;
}

public void setPublisher(String publisher) {
    this.publisher = publisher;
}

public int getPrice() {
    return price;
}

public void setPrice(int price) {
    this.price = price;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

@Override
public String toString() {
    return "Book{" + "author=" + author + ", title=" + title + ", edition=" + edition + ", publisher=" + publisher + ", price=" + price + ", quantity=" + quantity + '}';
}


}