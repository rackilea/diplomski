@Path("test")
public class TestResource { 
    public String doSomthing(@Context UriInfo uriInfo){
        return uriInfo.getAbsolutePath().toString();
    }
}
[...]
@Test
public void doTest() {
    UriInfo uriInfo = Mockito.mock(UriInfo.class);
    Mockito.when(uriInfo.getAbsolutePath())
        .thenReturn(URI.create("http://localhost:8080/test"));
    TestResource resource = new TestResource();
    String response = resource.doSomthing(uriInfo);
    Assert.assertEquals("http://localhost:8080/test", response);
}