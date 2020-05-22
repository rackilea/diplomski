/**
 * Value that indicates that default {@link java.util.TimeZone}
 * (from deserialization or serialization context) should be used:
 * annotation does not define value to use.
 *<p>
 * NOTE: default here does NOT mean JVM defaults but Jackson databindings
 * default, usually UTC, but may be changed on <code>ObjectMapper</code>.
 */
public final static String DEFAULT_TIMEZONE = "##default";