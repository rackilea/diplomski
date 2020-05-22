public class MyPrimitiveObject {
  private String identifier="unknown";
  public static class Builder {
    private final MyPrimitiveObject obj;
    public MyPrimitiveObject build() { return obj; }
    public Builder setidentifier (String val) {
     obj.identifier = val;
     return this;
    }

    public Builder() {
        this(new MyPrimitiveObject());
    }

    public Builder(MyPrimitiveObject obj) {
        this.obj = obj;
    }
  }
  ...
}

public class MySophisticatedObject extends MyPrimitiveObject {
  private String description;

  public static class Builder extends MyPrimitiveObject.Builder {
    private final MySophisticatedObject obj;
    public Builder() {
      this(new MySophisticatedObject());
      super.setIdentifier(generateUUID());
    }     
    public Builder(MySophisticatedObject obj) {
      super(obj);
      this.obj = obj;
    }

    public MySophisticatedObject build() {
      return obj;
    }

    // Add code to set the description etc.
  }
}