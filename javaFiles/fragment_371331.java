private class SomeObject {
  @SerializedName("custom_naming") private final String someField;
  private final String someOtherField;

  public SomeObject(String a, String b) {
    this.someField = a;
    this.someOtherField = b;
  }
}