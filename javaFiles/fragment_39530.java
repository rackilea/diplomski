public final class Messages {
    private Messages() {
        loadFile();
    }
    private static final class ThreadSafeSingleton {
        private static final Messages INSTANCE = new Messages();
    }
    public static Messages getInstance() {
        return ThreadSafeSingleton.INSTANCE;
    }


    private final Properties props = new Properties();

    private void loadFile() {
        InputStream is = null;

        try {
            is = new FileInputStream("messages.properties");
            props.load(is);
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
    }

    public String getMessage(String key) {
        if (key == null && key.isEmpty()) return "";

        return props.getProperty(key);
    }
}