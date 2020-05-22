public class Student implements Comparable<Student> {
  private String name;
  private int grade;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getGrade() {
    return grade;
  }
  public void setGrade(int grade) {
    this.grade = grade;
  }
  public int compareTo(Student o) {
    return this.getName().compareTo(o.getName());
  }
}