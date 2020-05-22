public Views {
    public Public {}
    public Private1 extends Public {}
    public Private2 extends Public {}
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
  @JsonView(Views.Public.class)
  public String name;
  @JsonView({Views.Private1.class})
  public String phone;
  @JsonView({Views.Private2.class})
  public String avatarUrl;
  ...
}