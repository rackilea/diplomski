import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Test {
    public static void main(String... args){

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        StringBuilder sb = new StringBuilder();

        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String element = it.next();
            sb.append(element);
            if(it.hasNext()){
                sb.append(", ");
            }
        }

        System.out.println(sb.toString()); //prints: one, two, three

    }
}