@Bean(name="fullSpot")
 // Not mandatory. If not specified, it takes the method name i.e., "fullSpotField" as qualifier name.
  public FieldDescriptor fullSpotField() {
     FieldDescriptor ans = new FieldDescriptor("full_spot", String.class);
     return ans;
  }

  @Bean("annotationIdSpot")
  // Same as above comment.
  public FieldDescriptor annotationIdField() {
     FieldDescriptor ans = new FieldDescriptor("annotationID", Integer.class);
     return ans;
  }