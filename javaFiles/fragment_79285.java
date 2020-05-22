import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class AnIterator {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(); 
        List<String> list2 = new ArrayList<>();

        list1.add("One");
        list1.add("Two");
        list1.add("Three");
        list1.add("Four");
        list1.add("Five");

        Iterator it = list1.iterator();
        while(it.hasNext()){
            String next = (String) it.next();
            String temp = next.toLowerCase();
            char x = temp.charAt(0);
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                it.remove();
                list2.add(next);
            }
        }

        System.out.println("Vowels: " + list2);
        System.out.println("Consonants: " + list1);

    }
}