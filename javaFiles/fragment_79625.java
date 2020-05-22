public class Data {
    public static LinkedHashMap<String, Integer> GUID_VALUES = new LinkedHashMap<String, Integer>();
    public static LinkedHashMap<Integer, Map<String, Integer>> GUID_ID_MAPPING = new LinkedHashMap<Integer, Map<String, Integer>>();

    static {
        Integer someNumber = 0; //or another value, its for initialize the key
        GUID_ID_MAPPING.put(someNumber,GUID_VALUES);
    }
}