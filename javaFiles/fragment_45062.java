public class IdHandler {

    Map<String, Integer> count = new HashMap<String, Integer>();

    public int count(String id) {
        return count.get(id);
    }

    public void export(Map<String, String> map) {
        for (String value : map.values()) {
            System.out.println(value);

            if (!count.containsKey(value)) {
                count.put(value, 1);
            } else {
                int i = count.get(value);
                count.put(value, ++i);
            }
        }
    }
}

public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "A");
    map.put("2", "B");
    map.put("3", "C");
    map.put("4", "B");
    map.put("5", "B");
    map.put("6", "C");

    IdHandler id = new IdHandler();
    id.export(map);

    System.out.println(id.count("B")); // output is 3
    System.out.println(id.count("C")); // output is 2
}