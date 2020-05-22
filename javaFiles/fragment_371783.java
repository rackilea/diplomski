public int read() throws IOException
{
    final int nextByte = source.read();
    if (nextByte != -1)
    [
        try {
            sign.update((byte) nextByte);
        } catch (java.security.SignatureException e) {
            throw new IOException("Unknown exception while signing file", e);
        }
    }

    return nextByte;
}