import  java.util.ArrayList;
    import  java.util.Arrays;
    import  java.util.List;
    import  java.util.Map;
    import  java.util.TreeMap;
/**
   <P>{@code java BooleanKeyedMapXmpl}</P>
 **/
public class BooleanKeyedMapXmpl  {
   public static final void main(String[] igno_red)  {

        System.out.println("<Boolean,String>:");
            Map<Boolean,String> mbs = new TreeMap<Boolean,String>();

            mbs.put(true, "hello"); 
            mbs.put(false, "goodbye");

            System.out.println("true: " + mbs.get(true));
            System.out.println("false: " + mbs.get(false));
            System.out.println();

        System.out.println("<Boolean,ArrayList<String>>:");
            Map<Boolean,List<String>> mbls = new TreeMap<Boolean,List<String>>();

            mbls.put(true, new ArrayList<String>());
            mbls.put(false, new ArrayList<String>());

            List<String> lsTrue = mbls.get(true);
                lsTrue.add("hello1");
                lsTrue.add("hello2");
                lsTrue.add("hello3");
                lsTrue.add("hello4");
                lsTrue.add("hello5");

            List<String> lsFalse = mbls.get(false);
                lsFalse.add("goodbye1");
                lsFalse.add("goodbye2");
                lsFalse.add("goodbye3");
                lsFalse.add("goodbye4");
                lsFalse.add("goodbye5");

            System.out.println("true: " + Arrays.deepToString(lsTrue.toArray()));
            System.out.println("false: " + Arrays.deepToString(lsFalse.toArray()));
   }
}