/**
 * Serialize objects to given media type using registered message converters
 */
public class SerializationHelper {

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    public SerializationHelper(ObjectFactory<HttpMessageConverters> messageConverters) {
        this.messageConverters = messageConverters;
    }

    public <T> ByteArrayHttpOutputMessage outputMessage(final T payload, final MediaType mediaType) throws Exception {
        if (payload == null) {
            return null;
        }

        List<HttpMessageConverter<?>> relevantConverters = messageConverters.getObject().getConverters().stream()
                .filter(converter -> converter.canWrite(payload.getClass(), mediaType))
                .collect(Collectors.toList());

        final ByteArrayHttpOutputMessage converted = new ByteArrayHttpOutputMessage();
        boolean isConverted = false;
        for (HttpMessageConverter<?> converter : relevantConverters) {
            try {
                ((HttpMessageConverter<T>) converter).write(payload, mediaType, converted);
                isConverted = true; //won't be reached if a conversion error occurs
                break; //stop iterating over converters after first successful conversion
            } catch (IOException e) {
                //swallow exception so that next converter is tried
            }
        }

        if (!isConverted) {
            throw new Exception("Could not convert " + payload.getClass() + " to " + mediaType.toString());
        }

        return converted;
    }

    /**
     * Provides a String representation of provided payload
     *
     * @param payload
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception if things go wrong (no registered serializer for payload type and asked MediaType, serialization failure, ...)
     */
    public <T> String asString(T payload, MediaType mediaType) throws Exception {
        return payload == null ?
                null :
                outputMessage(payload, mediaType).out.toString();
    }

    public <T> String asJsonString(T payload) throws Exception {
        return asString(payload, MediaType.APPLICATION_JSON_UTF8);
    }

    public static final class ByteArrayHttpOutputMessage implements HttpOutputMessage {
        public final ByteArrayOutputStream out = new ByteArrayOutputStream();
        public final HttpHeaders headers = new HttpHeaders();

        @Override
        public OutputStream getBody() {
            return out;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}