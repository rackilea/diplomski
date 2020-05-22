import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Map<String, Integer> person = new HashMap<>();
        person.put("John", 18);
        person.put("Tim", 32);
        person.put("Georges", 39);
        person.put("Mike", 45);
        person.put("Vikor", 17);
        //interate this map
        Iterator<Map.Entry<String,Integer>> itr = person.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String,Integer> p = itr.next();
            System.out.print(p.getKey() +" - "+p.getValue());
            if(p.getValue() >= 32)
                System.out.print("\t 32 or over");
           System.out.println();
        }

    }
}