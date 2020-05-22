public class Person {
    private static int lastId;
    private int id;
    private String name;
    private int age;

    public Person() {
      id = Person.lastId++;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }
}