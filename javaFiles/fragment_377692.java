@Provider
    @Consumes("customformat")
    public class CustomUnmarshaller implements MessageBodyReader {

        @Override
        public boolean isReadable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
            return true;
        }


        @Override
        public Object readFrom(Class aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
            Object result = null;
            try {
                result = unmarshall(inputStream, aClass); // un marshall custom format to java object here
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;


}
}