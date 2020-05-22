public class StreamFilterTest extends JerseyTest {

    public static class InputStreamFilter implements ContainerRequestFilter {

        @Override
        public ContainerRequest filter(ContainerRequest request) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                InputStream in = request.getEntityInputStream();
                ReaderWriter.writeTo(in, out);

                byte[] requestBytes = out.toByteArray();
                byte[] worldBytes = " World".getBytes(StandardCharsets.UTF_8);
                byte[] newBytes = new byte[requestBytes.length + worldBytes.length];
                System.arraycopy(requestBytes, 0, newBytes, 0, requestBytes.length);
                System.arraycopy(worldBytes, 0, newBytes, requestBytes.length, worldBytes.length);

                request.setEntityInputStream(new ByteArrayInputStream(newBytes));
            } catch (IOException ex) {
                Logger.getLogger(InputStreamFilter.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }

            return request;
        }
    }

    @Path("stream")
    public static class StreamResource {

        @POST
        public String post(InputStream in) throws Exception {
            ByteArrayInputStream bin = (ByteArrayInputStream) in;
            StringWriter writer = new StringWriter();
            ReaderWriter.writeTo(new InputStreamReader(bin), writer);
            return writer.toString();
        }
    }

    public static class AppConfig extends DefaultResourceConfig {
        public AppConfig() {
            super(StreamResource.class);
            getContainerRequestFilters().add(new InputStreamFilter());
        }
    }

    @Override
    public WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .initParam(WebComponent.RESOURCE_CONFIG_CLASS,
                        AppConfig.class.getName())
                .build();
    }

    @Test
    public void should_return_hello_world() {
        String response = resource().path("stream").post(String.class, "Hello");
        assertEquals("Hello World", response);
    }
}