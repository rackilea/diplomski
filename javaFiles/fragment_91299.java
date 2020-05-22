import java.util.Dictionary;
import java.util.Hashtable; // <-- Needed for Hashtable
import java.util.Enumeration;

 public class DictonaryTest  
 {
     public static void main(String[] args) 
     {
         Dictionary d = new Hashtable(); // <-- Initialise d with a Hashtable
         d.put(new Integer(1),new Integer(100));
         d.put(new Integer(2),new Integer(200));
         d.put(new Integer(3),new Integer(300));
         d.put(new Integer(4),new Integer(400));
         d.put(new Integer(5),new Integer(500));

         System.out.println("Size of dictionary : " + d.size());
         Enumeration ekey = d.keys();
         Enumeration eelement = d.elements();

         System.out.println("Keys in the Dictionary...");
         while(ekey.hasMoreElements()){
             System.out.println(ekey.nextElement() + "\t");
         }

         System.out.println("Elements in the Dictionary...");
         while(eelement.hasMoreElements()){
             System.out.println(eelement.nextElement() + "\t");
         }

     }

 }