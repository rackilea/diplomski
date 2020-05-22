/**
 * @param target {@linkplain File}
 * @return {@linkplain InputStream}
 * @throws Exception
 */
protected InputStream initInput(final File file)
    throws Exception {
    InputStream stream = null;
    try {
        if (file.isDirectory()) {
            // throw exception
        }
        if (!file.exists()) {
            // throw another exception
        }
        // 
        // read operations using this implementation will jump over all '\n' and '\r'
        //
        stream = new NoNewLineFileInputStream(file);

    } catch (FileNotFoundException e) {
        // throw another exception
    }
    return stream;
}