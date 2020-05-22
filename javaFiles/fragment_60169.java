public class Wrapper {
  public List<Stuff> stuff;

  // this will get called for every key in the root object
  @JsonAnySetter
  public void set(String code, List<Stuff> stuff) {
    // code is "1443", stuff is the list with stuff
    this.stuff = stuff;
  }
}

// simple stuff class with everything public for demonstration only
public class Stuff {
  public String name;
  public int count;
  public int distinctCount;
}