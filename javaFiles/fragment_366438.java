... 
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

... 
private ConcurrentMap<String, Boolean> created = new ConcurrentMap<>();
....
if ( created.putIfAbsent( id, Boolean.TRUE ) == null ) {
    somewhereElse.put( id, createThing() );
}