InputStream in = null;
try {
    in = new FileInputStream(file);
    // ...
} catch(IOException ioe) {
    // handle exception.
} finally {
    IOUtils.closeQuietly(in);
}