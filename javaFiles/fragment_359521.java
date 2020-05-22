import java.util.*;

public class DoIt {
    public static void main(String[] args) {
         List l = new ArrayList<String>();
         l.add("name1:val1");
         l.add("name1:val2");
         l.add("name1:val3");
         l.add("name1:val4");
         l.add("name2:val1");
        Map results = new HashMap<String,String>();
        for (Iterator i = l.iterator(); i.hasNext();) {
             String s = (String)i.next();
             String[] tmp = s.split(":");
             if (!results.containsKey(tmp[0])) {
                 System.out.println("-"+tmp[0]+"\n"+tmp[1]);
                results.put(tmp[0], tmp[1]);
             } else {
                 System.out.println(tmp[1]);
             }
         }
     }
}