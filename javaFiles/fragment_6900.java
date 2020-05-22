public class MyClass {
    private static HashMap<Integer, Integer> myMap;

    static {
        myMap = new HashMap<>();
        myMap.put(10, 20);
        myMap.put(20, 40);
    }
}