public void process(String text) {
  String[] lines = text.split("\n");
  List<MyObject> list = new ArrayList<MyObject>();
  Object myObj;
  for (String line : lines) {
    myObj = new MyObject(line);
    list.add(myObj);
    // 1. set myObj = null here
  }
  list = null; // 2
  // 3. do some other stuff
}

public class MyObject {
  private final String line;

  public MyObject(String line) {
    this.line = line;
  }
}