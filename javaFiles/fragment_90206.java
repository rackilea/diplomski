public class LoggingPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    public void setLocations(final Resource[] locations) {
        if(logger.isDebugEnabled())
            for (final Resource resource : locations) {
                logger.debug("Using resource: " + resource);
            }
            super.setLocations(locations);
    }

    @Override
    protected Properties mergeProperties() throws IOException {
        final Properties mergedProperties = super.mergeProperties();
        if(logger.isDebugEnabled())
            for (final Entry<String, Object> propertyEntry :
                new TreeMap<String, Object>((Map) mergedProperties).entrySet()) {

                logger.debug(
                    "Key:" + propertyEntry.getKey()
                + ", value:" + propertyEntry.getValue());
            }
        return mergedProperties;
    }

}