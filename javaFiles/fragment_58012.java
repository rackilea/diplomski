public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {

    private static final Logger LOGGER = Logger.getLogger(ExposedResourceMessageBundleSource.class);

    @Override
    protected Properties loadProperties(Resource resource, String fileName) throws IOException {

        LOGGER.info("Load " + fileName);
        return super.loadProperties(resource, fileName);
    }

    /**
     * Gets all messages for presented Locale.
     * @param locale user request's locale
     * @return all messages
     */
    public Properties getMessages(Locale locale){
        return getMergedProperties(locale).getProperties();
    }
}