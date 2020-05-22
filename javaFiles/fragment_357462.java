@EJB
private UserService userService;

@GET
public Response getUser() {
    User user = userService.find(1);

    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("user", user);
    Viewable v = new Viewable("/user", dataMap);
    Response r = Response.ok(v).build();
    return r;
}