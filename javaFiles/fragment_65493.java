try (
    FileInputStream in = new FileInputStream(file);
    java.nio.channels.FileLock lock = in.getChannel().lock();
    Reader reader = new InputStreamReader(in, charset)
) {
    ...
}