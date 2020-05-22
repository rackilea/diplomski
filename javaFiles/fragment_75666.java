import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Library {

    HashMap<String, List<String>> checkoutBooks;
    Library() {

        checkoutBooks = new HashMap<String, List<String>>();

    }


    public void checkoutBook(String isbn, String patron) {

        if (checkoutBooks.containsKey(isbn)) {
         checkoutBooks.get(isbn).add(patron);
        } else {
            List<String> patronlist = new ArrayList<String>();
            patronlist.add(patron);
            checkoutBooks.put(isbn, patronlist);
            System.out.println("hello");
        }
    }


    public static void main(String[] args){
        Library library = new Library();
        library.checkoutBook("000", "Cay Horstman");
       library.checkoutBook("000", "Sharron Morrow");

     }

}