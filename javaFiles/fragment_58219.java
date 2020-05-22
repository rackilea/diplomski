import java.util.*;

public class Test {
    private static final Map<String, Integer> map
        = new HashMap<String, Integer>();

    public static void main(String[] args) {
        getInt("Foo");
    }

    public static int getInt(String name) {
        Integer i = map.get(name);
        return i;
    }
}