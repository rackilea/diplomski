package utcTime;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name = "UtcMillis", category = "Lookup")
public class UtcMillisLookup implements StrLookup{
    /**
     * Lookup the value for the key.
     * @param key  the key to be looked up, may be null
     * @return The value for the key.
     */
    public String lookup(String key) {
        return String.valueOf(getUTCMillis());
    }

    /**
     * @return current UTC time in milliseconds
     */
    private long getUTCMillis(){
        return System.currentTimeMillis();
    }

    /**
     * Lookup the value for the key using the data in the LogEvent.
     * @param event The current LogEvent.
     * @param key  the key to be looked up, may be null
     * @return The value associated with the key.
     */
    public String lookup(LogEvent event, String key) {
        return String.valueOf(getUTCMillis());
    }
}