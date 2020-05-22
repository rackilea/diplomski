enum SampleFields {
  TWO_name("html"),
  TWO_find("css"),
  ONE_KEY_java("java"),
  ONE_KEY_jsp("jsp");
  ONE_KEY_oracle("oracle"),
  ...;

  private String value;

  private SampleFields(String v) { 
    value = v;
  }
}