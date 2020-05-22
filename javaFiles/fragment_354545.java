enum MyEnum {
  SectionOne("Section ([1-9]|1[0-6]) Stuff") {
    @Override
    public void doSomething() {
      // implementation for section one when regex matches
    }
  }, SectionTwo("Section ([1-9]|1[0-6]) Stuff 2") {
    @Override
    public void doSomething() {
      // implementation for section two when regex matches
    }
  }, Param1("ParamValue1") {
    @Override
    public void doSomething() {
      // implementation for param 1
    }
  }, Param2("ParamValue2") {
    @Override
    public void doSomething() {
      // implementation for param 2
    }
  };

  private final Pattern regex;

  private MyEnum(String strRegex) {
    this.regex = Pattern.compile(strRegex);
  }

  public abstract void doSomething();

  public static MyEnum valueFor(String value) {
    for (MyEnum myEnum : MyEnum.values()) {
      if(myEnum.regex.matcher(value).matches()) {
        return myEnum;
      }
    }
    return null;
  }
}