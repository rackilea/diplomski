/**
 * Get String from file Which contains Index mapping in JSON format.
 *
 * @param fileName file which needs to be read into JSON.
 * @return
 */
public String getStringFromFile(String fileName) throws IOException {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    InputStream in = classLoader.getResourceAsStream(fileName);
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    while ((length = in.read(buffer)) != -1) {
        result.write(buffer, 0, length);
    }
    return result.toString(StandardCharsets.UTF_8.name());
}