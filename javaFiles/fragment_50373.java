@Test
public void testSessionSet(WebTarget target) {
    Response response0 = target.path("session").request().put(Entity.entity("{}", MediaType.APPLICATION_JSON_TYPE));
    System.out.println("PUT:  status="+response0.getStatus()+" response="+response0.readEntity(String.class));

    Invocation.Builder nextRequestBuilder = target.path("session").request();
    NewCookie jsessionid = response0.getCookies().get("JSESSIONID");
    if (jsessionid != null) {
        nextRequestBuilder.cookie(jsessionid);
    }
    Response response1 = nextRequestBuilder.get();
    System.out.println("GET:  status="+response1.getStatus()+" response="+response1.readEntity(String.class));
}