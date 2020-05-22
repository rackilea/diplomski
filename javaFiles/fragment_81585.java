public class OSAgnosticPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        Path resolvedFilePath = Paths.get(resource.getResource().getURI()).resolve(name);
        EncodedResource er = new EncodedResource(new PathResource(resolvedFilePath), resource.getCharset());
        return (name != null ? new ResourcePropertySource(name, er) : new ResourcePropertySource(er));
    }

}