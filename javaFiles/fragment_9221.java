class CustomHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    @Override
    public Object read(
            final Type type,
            final Class<?> contextClass,
            final HttpInputMessage inputMessage) throws IOException {
        return super.read(type, contextClass, new CachedHttpInputMessage(inputMessage));
    }

    @Override
    protected Object readInternal(
            final Class<?> clazz,
            final HttpInputMessage inputMessage) throws IOException {
        return super.readInternal(clazz, new CachedHttpInputMessage(inputMessage));
    }
}