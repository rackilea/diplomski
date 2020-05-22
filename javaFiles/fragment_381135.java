public enum MapHelper {
; // Utility class for working with maps
public static <K,V> void multiKeyPut(Map<? super K,? super V> map, K[] keys, V value) {
for(K key : keys) {
    map.put(key, value);
}}}