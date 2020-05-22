public class SpringResourceLoader {

    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // Ant-style path matching
        Resource[] resources = resolver.getResources("/com/myapp/some/package/*");

        for (Resource resource : resources) {
            InputStream is = resource.getInputStream();
            ...
        }
    }
}