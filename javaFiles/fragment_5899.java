public class ResourceTest extends JerseyTest {

    @Path("test")
    public static class TestResource {
        @GET
        public Response doSomthing(@Context UriInfo uriInfo) {
            return Response.ok(uriInfo.getAbsolutePath().toString()).build();
        }
    }

    @Override
    public Application configure() {
        return new ResourceConfig(TestResource.class);
    }

    @Test
    public void test() {
        String response = target("test").request().get(String.class);
        Assert.assertTrue(response.contains("test"));
    }
}