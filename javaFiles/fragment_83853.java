private final Map<File, byte[]> cache = new HashMap<File, byte[]>();

public synchronized byte[] readFile(File file) throws IOException {
    byte[] content = cache.get(file);
    if (content == null) {
        content = Files.readAllBytes(file.toPath());
        cache.put(file, content);
    }
    return content;
}