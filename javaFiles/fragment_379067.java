import java.util.*;

public class AClass {

    static Map<String, List<Object>> myMap = new HashMap<>();
    static final int ALPHA_ZULU = 0;
    static final int SOME_DOUBLE = 1;

    public static void main(String[] args) {

        List<Object> l1 = new ArrayList<>();
        l1.add("CHARLIE");
        l1.add(new Double(1));
        List<Object> l2 = new ArrayList<>();
        l2.add("ZULU");
        l2.add(new Double(9));
        List<Object> l3 = new ArrayList<>();
        l3.add("ALPHA");
        l3.add(new Double(12));
        List<Object> l4 = new ArrayList<>();
        l4.add("XRAY");
        l4.add(new Double(4));

        myMap.put("one", l1);
        myMap.put("two", l2);
        myMap.put("three", l3);
        myMap.put("four", l4);


        List<Map.Entry<String, List<Object>>> meList = new ArrayList<>(myMap.entrySet());
        Collections.sort(meList, new MyComaprator(ALPHA_ZULU));

        for(Map.Entry me : meList) {
            System.out.println(me.getKey() + " = " + me.getValue());
        }

    }






}


class MyComaprator implements Comparator<Map.Entry<String,List<Object>>> {

    final int compareIndex;

    public MyComaprator(int compareIndex) {
        this.compareIndex = compareIndex;
    }

    @Override
    public int compare(Map.Entry<String, List<Object>> me1, Map.Entry<String, List<Object>> me2) {

        Object item1 = me1.getValue().get(compareIndex);
        Object item2 = me2.getValue().get(compareIndex);
        int compareResult = 0;

        if(item1 instanceof String && item2 instanceof String) {
            compareResult = ((String)item1).compareTo((String)item2);
        } else if(item1 instanceof Double && item2 instanceof Double) {
            compareResult = (int)((double)item1 - (double)item2);
        } else {
            // invalid comparison perhaps?
        }

        return compareResult;
    }
}