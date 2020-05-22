enum MyEnum {
  A("AA"),
  B("BB"), 
  C("CC");

  private final String value;  

  public MyEnum(String value){
    this.value = value;
  }

  public String f(){
    return value;
  }
}