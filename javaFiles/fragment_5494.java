public class FooBean implements Serializable {
  private String ID;
  public String getID() { return ID; }
  public void setID(String iD) { ID = iD; }

  public static void main(String[] args) throws Exception {
    for (PropertyDescriptor property : Introspector.getBeanInfo(FooBean.class)
        .getPropertyDescriptors()) {
      System.out.println(property.getName()
          + (property.getWriteMethod() == null ? " (readonly)" : ""));
    }
  }
}