public Views {
    public Public {}
    public Private extends Public {}
}

class CarUI {
  public UserUI user;
  public UserUI agent;
  ....
  @JsonView(Views.Public.class)
  public UserUI getUser() {
    return user;
  }
  @JsonView(Views.Private.class)
  public UserUI getAgent() {
    return agent;
  }
}

class UserUI {
  @JsonView(Views.Public.class)
  public String name;
  @JsonView(Views.Private.class)
  public String phone;
  ...
}