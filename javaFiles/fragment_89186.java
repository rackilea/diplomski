import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

...

 private static final Object PRESENT = new Object();
 Map<String, Object> seenStrings = new ConcurrentHashMap<>();



for ( String aString : stringList ) {
    if ( seenStrings.containsKey(aString) ) {
        // Already there
    } else {
        // Not seen yet
        seenStrings.put(aString, PRESENT);
    }
}