// Note: return code is byte[]
protected byte[] readResponse(final InputStream in)
    throws IOException
{
    try (
        final InputStream gzin = new GzipInputSream(in);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
    ) {
        final byte[] buf = new byte[4096];
        int bytesRead;
        while ((bytesRead = gzin.read(buf)) != -1)
            out.write(buf, 0, bytesRead);

        return out.toByteArray();
    }
}