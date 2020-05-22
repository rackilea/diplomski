import java.lang.reflect.Field;
import java.util.*;

class Test {

    public static void main(String[] args) throws Exception {

        SubHashMap<String, Integer> map = new SubHashMap<String, Integer>();

        map.put("zero",  0); map.put("one",   1); map.put("two", 2);
        map.put("three", 3); map.put("four",  4); map.put("five", 5);
        map.put("six",   6); map.put("seven", 7); map.put("eight", 8);

        map.dumpBuckets();
    }

}