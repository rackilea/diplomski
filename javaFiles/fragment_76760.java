public static void copyStream(InputStream input, OutputStream output)
     throws IOException
{
    // Reads up to 8K at a time. Try varying this.
    byte[] buffer = new byte[8192];
    int read;

    while ((read = input.read(buffer)) != -1)
    {
        output.write(buffer, 0, read);
    }
}