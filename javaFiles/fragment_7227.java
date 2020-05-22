public class UriBuilderTest {

    @Path("/v0/app")
    public static class AppController {

        @Path("/{app-id}")
        public String getApp(@PathParam("app-id") int appid) {
            return null;
        }
    }

    @Test
    public void testit() {
       URI uri = UriBuilder
               .fromResource(AppController.class)
               .path(AppController.class, "getApp")
               .resolveTemplate("app-id", 1)
               .build();

        assertEquals("/v0/app/1", uri.toASCIIString());
    }
}