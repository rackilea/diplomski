import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
public class GroupAndFindMinimum {

    public static void main(String[] args) {

        HashMap<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
        comparatorPQ comp = new comparatorPQ<String>();

        PriorityQueue<String> q1 = new PriorityQueue<String>(3,comp);
        q1.add("1.12");q1.add("1.13");q1.add("1.45");

        PriorityQueue<String> q2 = new PriorityQueue<String>(2,comp);
        q2.add("5.6");q2.add("4.5");

        PriorityQueue<String> q3 = new PriorityQueue<String>(1,comp);
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

class comparatorPQ<k> implements Comparator
{

    @Override
    public int compare(Object a1, Object b1) {
        String a = null ,b= null;

        if(a1 instanceof String)
         a = (String)a1;

        if(b1 instanceof String)
        b = (String)b1;


        if( b.compareTo(a) > 1 )
            return 1;
        else if(b.compareTo(a) < 1)
            return -1;
        return 0;
    }

}