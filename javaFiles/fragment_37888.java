interface IUserInput {
  public String getUserName();
  public XO_Enum getUserSymbol();
}

class MockUserInput implements IUserInput {
    private XO_Enum xo;
    private String name;
    public MockUserInput(String name_, XO_Enum xo_) {
      xo = xo_;
      name = name_;
    }
    public String getUserName() { return name; }
    public XO_Enum getUserSymbol() { return xo; }
}