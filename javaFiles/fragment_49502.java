public class Q37066776 {
    public static void main(String[] args) {
        System.out.println(Hash.getMap().get("key").get("key2"));
    }

}

class Hash {
    private static Map<String, Map<String, String>> wow = new HashMap<String, Map<String, String>>();

    static {
        wow.put("key", new HashMap<String, String>());
        wow.get("key").put("key2", "val2");
    }

    public static Map<String, Map<String, String>> getMap() {
        return wow;
    }
}