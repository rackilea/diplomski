public final class Messages {
    private Messages() {} // Not instantiable

    private static final Properties props = loadFile(); // Make sure this static field is at the top

    public static final String FOO = getMessage("foo");
    public static final String BAR = getMessage("bar");

    private static Properties loadFile() {
        final Properties p = new Properties();

        InputStream is = null;

        try {
            is = new FileInputStream("messages.properties");
            p.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return p;
    }

    public static String getMessage(String key) {
        if (key == null && key.isEmpty()) return "";

        return props.getProperty(key);
    }
}