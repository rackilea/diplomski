public class ProxyMultiPartTest extends JerseyTest {

    public static interface IUploadResource {
        @POST
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        String upload(FormDataMultiPart multipart) throws Exception;
    }

    @Path("upload")
    public static class UploadResource implements IUploadResource {
        @Override
        public String upload(FormDataMultiPart multiPart) throws Exception {
            FormDataBodyPart bodyPart = multiPart.getField("file");
            FormDataContentDisposition fdcd = bodyPart.getFormDataContentDisposition();
            System.out.println("filename: " + fdcd.getFileName());
            System.out.println("size: " + fdcd.getSize());
            InputStream body = bodyPart.getValueAs(InputStream.class);
            StringWriter writer = new StringWriter();
            ReaderWriter.writeTo(new InputStreamReader(body), writer);
            return writer.toString();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(UploadResource.class)
                .register(MultiPartFeature.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));

    }

    @Test
    public void testProxyClientUpload() throws Exception {
        try (Writer writer = new BufferedWriter(new FileWriter("demo.txt"))) {
            writer.write("Hello World");
        }
        WebTarget target = target("upload").register(MultiPartFeature.class);
        IUploadResource resource = WebResourceFactory.newResource(IUploadResource.class, target);
        FileDataBodyPart filePart = new FileDataBodyPart("file", new File("demo.txt"));
        FormDataMultiPart multiPart = new FormDataMultiPart();
        multiPart.bodyPart(filePart);

        String response = resource.upload(multiPart);
        assertEquals("Hello World", response);
    }
}