public enum Test {
    a("This is a"),
    b("This is b"),
    c("This is c"),
    d("This is d");

    private final String type;

    Test(String type) {
        this.type = type;
    }

    public String getType() {
         return type;
    }

    public static Test getByDesc(String desc){
      for(Test t : Test.values()){
        if(t.getType().equals(desc)){
          return t;
        }
      }
      return null;
    }

}