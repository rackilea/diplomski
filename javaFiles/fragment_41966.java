@ProtoClass(ProtoObject.class)
Class DomainClass{
  @ProtoField
  private String field1;
  @ProtoField(name = "xyz") // in case proto and domain class field have different names
  private String field2;
}