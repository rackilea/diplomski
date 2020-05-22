/**
 * This implementation throws IllegalStateException if attempting to
 * read the underlying stream multiple times.
 */
public InputStream getInputStream() throws IOException, IllegalStateException {
    if (this.read) {
        throw new IllegalStateException("InputStream has already been read - " +
                "do not use InputStreamResource if a stream needs to be read multiple times");
    }
    this.read = true;
    return this.inputStream;
}