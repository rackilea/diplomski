public class Base {
  String something;

  public void onCreate() {
    something = "a value";
  }
}

public class Student extends Base {
    int age;
    String name;
    String badgeid;
    int value;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
        this.badgeid = this.age + this.name;
        this.value = something.length;
    }
}