@Path("test")
public class TestResource {

    final String path = "some_150_mb_file";

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response doTest() throws Exception {
        InputStream is = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[4096];
        while ((len = is.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, len);
        }
        System.out.println("Server size: " + baos.size());
        return Response.ok(baos).build();
    }
}