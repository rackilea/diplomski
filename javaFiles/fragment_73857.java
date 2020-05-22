public enum Contents {      
  VarA, VarB, VarC;

  private final Method getter;

  private Contents() {
    try {
      this.getter = Database.class.getMethod("get"+name());
    } catch (Exception e) { throw new RuntimeException(e); }
  }
  public String get(Database d) {
    try {
      return (String) getter.invoke(d); 
    } catch (Exception e) { throw new RuntimeException(e); }
  }
}