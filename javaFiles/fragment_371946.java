public static void closeQuietly(Closeable c) {
    if (c != null) {
       try {
           c.close();
       } catch (IOException ioe) {
           // ignore or trace log it
       }
    }
}