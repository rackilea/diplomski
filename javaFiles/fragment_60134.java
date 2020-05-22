public int read(char[] cbuf, int off, int len) throws IOException {
    char[] result = "Test\n".toCharArray();
    int numRead = Math.min(len, result.length);
    System.arraycopy(result, 0, cbuf, off, numRead);
    return numRead;
}