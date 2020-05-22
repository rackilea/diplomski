public Views {
    public Public {}
    public Private {}
}

class CarUI {
  public UserUI user;
  public UserUI agent;
  ....
  public UserUI getUser() {
    return user;
  }
  public UserUI getAgent() {
    return agent;
  }
}
class UserUI {
  // This one is view-less shows every time unless you specificy
  public String name;
  @JsonView({Views.Private.class})
  public String phone;
  @JsonView({Views.Public.class})
  public String avatarUrl;
  ...
}

...
// If you want to hide view-less properties, default is true 
objectMapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false); 
...