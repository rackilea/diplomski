public class Q37066776 {
    public static void main(String[] args) {
        Hash h = new Hash();
        h.SetHash();
        Map<String, String> m = (HashMap<String, String>) h.GetMap().get("key");
        System.out.println(m.get("key2"));
    }

}

class Hash {
    private HashMap<String, HashMap<String, String>> wow = new HashMap<String, HashMap<String, String>>();

    public void SetHash() {
        wow.put("key", new HashMap<String, String>());
        wow.get("key").put("key2", "val2");
    }

    public HashMap GetMap() {
        return wow;
    }
}