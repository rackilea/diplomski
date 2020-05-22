public class Utils {

    public <T, K> List<T> map2list(Map<T, K> map) {
        List<T> list = new ArrayList<T>(map.keySet());
        return list;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test1", 1);
        map.put("test2", 2);
        map.put("test3", 3);
        Utils t = new Utils();
        List<String> result = t.map2list(map);
        for (String key : result) {
            System.out.println(key);
        }
    }

}