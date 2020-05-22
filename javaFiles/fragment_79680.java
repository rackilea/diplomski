import java.util.Arrays;
import java.util.PriorityQueue;

public class BookQueue {
    public static void main(String[] args) throws BookException {

        PriorityQueue<Book> pq = new PriorityQueue<Book>();
        pq.offer(new Book(32, true, "Green eggs and ham", 12));
        pq.offer(new Book(42, true, "Hop on Pop", 11));
        pq.offer(new Book(20, true, "Lorax", 19));
        pq.offer(new Book(20, false, "Lorax", 19));
        pq.offer(new Book(22, true, "Cat in the hat", 10));

        // Iterator itr = pq.iterator();
        // System.out.println("\n");
        // while(itr.hasNext()){
        //   System.out.println(itr.next());
        //}

        Book[] books = new Book[pq.size()];
        Arrays.sort(pq.toArray(books));
        System.out.println("\n");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}