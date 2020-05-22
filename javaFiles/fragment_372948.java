import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Author {

    private String name;
    private int bookCount;

    public Author() {
    }

    public Author(String name, int bookCount) {
        this.name = name;
        this.bookCount = bookCount;
    }

    public String getName() {
        return name;
    }

    public int getBookCount() {
        return bookCount;
    }
}

class Book {

    private String name;
    private int year;
    private Author author;

    public Book(String name, int year, Author author) {
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + year + " - " + author.getName() + ")";
    }

}

public class TestingLambdas2 {

    public static void main(String [] args) {

        Author hgWells = new Author("H. G. Wells", 2);
        Author hLee = new Author("Harper Lee", 1);

        Book book1 = new Book("War of the Worlds", 1898, hgWells);
        Book book2 = new Book("The Time Machine", 1895, hgWells);
        Book book3 = new Book("To Kill a Mockingbird", 1960, hLee);

        List<Book> books = Arrays.asList(book1, book2, book3);
        System.out.println("> All books:" + books);

        Predicate<Book> yearFilter = book -> book.getYear() > 1899;
        System.out.println("> Filtered book author(s):");
        books.stream()
                .filter(yearFilter)
                .map(book -> book.getAuthor().getName())
                .forEach(authorName -> System.out.println(authorName));
    }
}