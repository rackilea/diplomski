try {
    URL resource = getClass().getClassLoader().getResource("demo/test.txt");
    if (nonNull(resource)) {
        File file = new File(resource.toURI());
        // do something
    }
} catch (URISyntaxException e) {
    LOGGER.error("Error while reading file", e);
}