import java.util.*;
import java.io.*;
public class MyClass {
    public static void main(String[] args) throws Exception {
        ArrayList<LinkedList<String>> list = new ArrayList<>(26);
        for(int i = 0; i < 26; i++) {
            list.add(new LinkedList<String>());
        }
        Scanner sc = new Scanner(new File("words.txt"));
        while(sc.hasNext()) {
            String next = sc.next();
            char c = next.toUpperCase().charAt(0);
            int index = c - 'A';
            list.get(index).add(next);
        }
        // let's test it by looking at all the H words
        System.out.println(list.get(7));
    }
}