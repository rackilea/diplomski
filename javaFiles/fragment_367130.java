import java.util.ArrayList;
import java.util.Scanner;

public class BookCapture {

     static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String ase[]){

        for(int i=0;i<5;i++){
            capture();
        }
       System.out.println(books.toArray());
    }

    public static void capture(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the book called?..");
        String bTitle = input.nextLine();
        System.out.println("Who is the author?..");
        String bAuthor = input.nextLine();
        System.out.println("How many do you have?..");
        int bQuantity = input.nextInt();
        System.out.println("How many are out on loan?..");
        int bNumOnLoan = input.nextInt();
        System.out.println("How many times has it been loaned?..");
        int bNumTimesLoaned = input.nextInt();

        Book object = new Book(bTitle, bAuthor, bQuantity, bNumOnLoan, bNumTimesLoaned);
        books.add(object);
    }
}
class Book{
    // your book class
    // do override your tostring() method;
}