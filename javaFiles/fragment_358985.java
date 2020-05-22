public class MyClassChild extends SuperClass {

  private long myprimarykey;
  private String some column;
  private long myversion;  

  // Override superclass mappings
  @Transient
  long getId() { return super.getId(); }
  @Transient
  void setId(long id) { return super.setId(long id); }
  // etc...
}