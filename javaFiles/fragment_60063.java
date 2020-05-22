public class TestFileUtil {
    private static final ClassLoader classLoader = TestFileUtil.class.getClassLoader();

    public static Map<String, Object> getJsonFileAsMap(String fileLocation) {

        try {
            return new ObjectMapper().readValue(getTestFile(fileLocation), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON file to a Map", e);
        }
    }

    private static URL getTestFile(String fileLocation) {

        return classLoader.getResource(fileLocation);
    }
}