public static void route(InputStream inputStream, OutputStream outputStream) 
throws IOException {
    byte[] buffer = new byte[65536];
    try {
        while( true ) {
            ...
            b = inputStream.read(...);
            if( b == - 1 ) {
                log.info("No data available anymore. Closing stream.");
                return;
            }
            outputStream.write(buffer, 0, b+1);
        }
    } finally {
        try { inputStream.close();} catch (IOException ex) { /* ignore */ }
        try { outputStream.close();} catch (IOException ex) { /* ignore */ }
    }
}