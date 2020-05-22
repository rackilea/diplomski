Please check following program for your requirement

    I have created HashMap where Key as the your values that will duplicate and ArrayList as List of value duplicated  


    import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Dog {


    public static void main(String[] args) {
        Map<Integer,List<Integer>> hashMap=new HashMap<Integer,List<Integer>>();
         int array[]={1,1,1,2,2,2,4,3,3,3};


         for (int m = 0; m < array.length ; m++) {
             System.out.print(array[m]);
             List<Integer> dup=(List<Integer>)hashMap.get(array[m]);
             if(dup==null){

                 dup=new ArrayList<Integer>();
                 hashMap.put(array[m],dup);
                 dup.add(array[m]);

             }else{
                 dup.add(array[m]);
             }
         }

         Set<Entry<Integer, List<Integer>>> keys = hashMap.entrySet();
         for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            Entry<Integer, List<Integer>> entry = (Entry<Integer, List<Integer>>) iterator.next();
            List<Integer> arrayList = entry.getValue();
            if(arrayList.size()==1)
                hashMap.put(entry.getKey(), null);
        }


         System.out.print(hashMap.get(1));
         System.out.print(hashMap.get(2));
         System.out.print(hashMap.get(3));
         System.out.print(hashMap.get(4));
    }
}