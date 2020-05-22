import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name = "marker", category = "Lookup")
public class MarkerLookup implements StrLookup {

    public String lookup(String key) {
        return null
    }

    public String lookup(LogEvent event, String key) {
        final Marker marker = event.getMarker();
        return marker == null ? null : marker.getName();
    }
}