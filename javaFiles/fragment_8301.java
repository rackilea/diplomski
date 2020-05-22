public class MapUtils {

    public static <T> T getSingleValue(Map<String, Object> map) {
        return (T) map.values().toArray()[0];
    }
}