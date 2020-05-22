public class InputStreamBeanProxy extends BeanProxy {

    @Override
    public Object getValue(Object instance, String propertyName) {
        Object value = super.getValue(instance, propertyName);
        if (value instanceof InputStream) {
            value = getByteArray((InputStream) value);
        }
        return value;
    }

    private byte[] getByteArray(InputStream stream) {

        try {
            byte[] bytes = IOUtils.toByteArray(stream);
            return bytes;
        } catch (IOException e) {
            logger.error("Exception serializing inputStream: ", e);
            throw new RuntimeException(e);
        }
    }

}