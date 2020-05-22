/**
 * Constant holder for exceptionally database IT testing purposes
 * for switching between h2 and mysql
 */
public class ActiveProfile {
    /**
     * Current profile for database IT tests.
     * Make sure the value is equal to the value of
     * <i>spring.profiles.active</i> property from test application.properties
     */
    public static final String NOW = "h2";
}