public static String loadResourceToString(final String path){
    final InputStream stream =
        Thread
            .currentThread()
            .getContextClassLoader()
            .getResourceAsStream(path);
    try{
        return IOUtils.toString(stream);
    } catch(final IOException e){
        throw new IllegalStateException(e);
    } finally{
        IOUtils.closeQuietly(stream);
    }
}