@Context
 private ResourceContext context;

 @Path(...)
 public SubResource getSub(){
  return context.getResource(SubResource.class);
 }