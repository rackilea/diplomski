InputStream stream = ...;
try {
    ...
}
finally {
    IOUtils.closeQuietly(stream);
}