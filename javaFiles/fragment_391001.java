@Test
public void postBody() throws Exception {          
    Response response = null;
    try {
        response = server.newRequest("...").request().buildPost(Entity.text("...")).invoke();           
    } finally {
        response.close();
    }   
}