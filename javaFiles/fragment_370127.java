private final static String COUNTER = "C:\\GameCounter\\info.txt";

    public static void main(String[] args) {
        File file = new File(COUNTER);
        if (!file.exists()) {
            try {
                PrintWriter writer = new PrintWriter(COUNTER, "UTF-8");
                writer.println("Info File:");
                writer.flush();
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        /// ... more to come
    }