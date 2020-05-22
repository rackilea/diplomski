public ComplexClass {
   public Long id;
   public String name;
   // And lots of other fields you don't want

   public String toJsonString() {
     // Include id & name, exclude all others.
     JSONSerializer ser = new JSONSerializer().include(
            "id",
            "name",
     ).exclude("*");
    return ser.serialize(this);
  }