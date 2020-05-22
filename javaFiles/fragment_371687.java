public class Test {
private final String name;
private List<String> list;

public Test(String name) {
    this.name = name;
}

void add(String s) {
    list.add(s);
}

List<String> getList() {
  if (list == null) {
    list = new ArrayList<>();
  }
  return list;
}

void print() {
    System.out.println("name: " + name);
    for (String s : getList()) {
        System.out.println(" - " + s);
    }
}
}