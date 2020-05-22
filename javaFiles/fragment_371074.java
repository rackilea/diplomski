import java.util.*;
  public class StudentClass
  {
  List<Student> studentList;
  private String studentName;
  private int lengthOfString;

  public StudentClass()
  {
  super();
  studentList = new ArrayList<>();
  }

  public void addStudent(String aName) {
  Student student = new Student(aName);
  studentList.add(student);
  }      
  }

  public class Student
  {

  private String name;
  private int mark;

  public Student(String aName)
  {
  super();
  this.name = aName;
  this.mark = -1;   
  }
  }