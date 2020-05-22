/app/rest/user/user4?some=value1&other=value2&data=value3

 public String deleteUser(@PathParam("id") final String id,
                          @QueryParam("some") String some,
                          @QueryParam("other") String other,
                          @QueryParam("data") String data) {}