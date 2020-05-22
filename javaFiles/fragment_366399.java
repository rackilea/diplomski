public class People {
  private final Person[] everyone = { new Person("Bill"), new Person("Ben") };

  public Person[] getEveryone() {
    return everyone;
  }

  public static class Person {
    private String name;
    public Person(String name) { this.name = name; }
    public Person() {}
    public String getName() { return name; }
  }
}