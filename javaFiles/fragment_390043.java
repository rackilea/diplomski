public class Test {

    public static void main(String[] args) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        put(map, "R1", "Data1");
        put(map, "R2", "Data2");
        put(map, "R1", "Data3");
        put(map, "R2", "Data4");

        System.out.println(map); // prints {R1=[Data1, Data3], R2=[Data2, Data4]}
    }

    public static void put(Map<String, List<String>> map, String key, String value) {
        if (map.get(key) == null) {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        } else {
            map.get(key).add(value);
        }
    }
}