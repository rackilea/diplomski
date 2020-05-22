public class Globals {
    private static final Properties properties = new Properties();

    static {
        // do the loading here
    }

    public static final int TILE_SIZE = 
        Integer.valueOf(properties.getProperty("tile.size"));
    public static final String SCREENSHOT_DIR = 
        properties.getProperty("screenshot.dir");
    // etc
}