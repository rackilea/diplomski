public StreamResponse onImage() {
    StreamResponse result = null;
    if (graphic != null && graphic.getImage() != null) {
        try {
            InputStream input = new FileInputStream(graphic.getImage());
            result = new PngInline(input, "test");
        } catch (FileNotFoundException e) {
            logger.error("Loading graphic image", e);
        }
    }
    return result;
}
@Inject
private ComponentResources resources;

public Link getLink() {
    return resources.createEventLink("image", new Object[]{});
}