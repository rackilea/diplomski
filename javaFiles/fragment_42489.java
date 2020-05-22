abstract class View {

protected static HashMap<String, View> viewMap = new HashMap<String, View>();

public static void addMap(String key, View value) {
    viewMap.put(key, value);
}