private static void throwIoException(Exception e)
    throws IOException // <<= Add other "allowed" exceptions here
{
    if (e instanceof IOException) {
        throw (IOException)e;
    }
    ... // <<= Add checks for other "allowed" exceptions here
    throw new IOException(e.getMessage(), e);
}