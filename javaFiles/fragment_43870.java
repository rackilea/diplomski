import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTester {

   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Library lib = new Library();
    ArrayList<Book> books = lib.getBooks();
    MenuInput(sc, books);
    sc.close();
}