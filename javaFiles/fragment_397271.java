import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
public class GroupAndFindMinimum {

    public static void main(String[] args) {

        HashMap<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();

        PriorityQueue<String> q1 = new PriorityQueue<String>();
        q1.add("1.12");q1.add("1.13");q1.add("1.45");

        PriorityQueue<String> q2 = new PriorityQueue<String>();
        q2.add("5.6");q2.add("4.5");

        PriorityQueue<String> q3 = new PriorityQueue<String>();
        q3.add("5.6.4");

        map.put("A",q1);
        map.put("B", q2);
        map.put("C", q3);


        for(Iterator<? extends Map.Entry<? extends String, ? extends PriorityQueue<String>>> it = map.entrySet().iterator(); it.hasNext() ;)
        {
            Map.Entry<? extends String, ? extends PriorityQueue<String>> t = it.next();
            System.out.println(t.getKey() + " " + t.getValue().peek());
        }

    }

}