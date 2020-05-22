import java.util.*;
import java.util.stream.*;

public class Answer {
  public static void main(String[] args) {
    List<Student> studentsWithoutAge = Arrays.asList(
      new Student("1", "Vishwa", null),
      new Student("3", "Ravi", null),
      new Student("2", "Ram", null)
    );

    Map<String,String> ageById = new HashMap() {{
      put("1","20");
      put("2","30");
    }};

    List<Student> studentsWithAge = addAge(studentsWithoutAge, ageById);

    System.out.println("Students without age: " + studentsWithoutAge);
    System.out.println("Students with age: " + studentsWithAge);
  }

  static List<Student> addAge(List<Student> students, Map<String,String> ageById) {
    return students.stream()
                   .map(student -> {
                      String age = ageById.getOrDefault(student.getId(), null);
                      return new Student(student.getId(), student.getName(), age);
                   })
                   .collect(Collectors.toList());
  }
}

class Student {
  private String name;
  private String age;
  private String id;
  Student(String id,String name,String age){
    this.id = id;
    this.name = name;
    this.age = age;
  }
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public String getAge() {
      return age;
  }
  public void setAge(String age) {
      this.age = age;
  }
  public String getId() {
      return id;
  }
  public void setId(String id) {
      this.id = id;
  }
  @Override
  public String toString() {
    return String.format("Student: id = %s, name = %s, age = %s", this.id, this.name, this.age);
  }
}