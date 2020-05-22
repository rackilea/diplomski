@POST
@Path("logIn")
public Viewable login() {
    Map<String, String> model = new HashMap<>();
    model.put("key1", "value1");
    model.put("key2", "value2");

    return new Viewable("/feed", model);
}