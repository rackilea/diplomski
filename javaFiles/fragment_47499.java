public class Dictionary {
    Map<String, Integer> map = new HashMap<>();

    public boolean contains(String key) {
        for(String mapKey : map.keySet()) {
            if(mapKey == key) {
                return true;
            }
        }
        return false;
    }
}