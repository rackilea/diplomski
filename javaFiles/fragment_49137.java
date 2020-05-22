import java.util.Iterator;
import java.util.LinkedList;

public class Tester {
  public static void main(String[] args) {
    Registry r = new Registry();
    r.addStudent(new Student("13", "John", "Doe", "Physics")); // Add a student to the Registry
    r.addStudent(new Student("212", "Jane", "Bow", "Chem")); // Add another Student
    System.out.println(r); // Print the Student List

    r.deleteStudent(212); // Deletes student with ID 212
    System.out.println(r);
  }
}


class Student {
  private String studentID;
  private String foreName;
  private String surName;
  private String degreeScheme;

  public Student(String studentId, String foreName, String surName, String degreeScheme) {
    this.studentID = studentId;
    this.foreName = foreName;
    this.surName = surName;
    this.degreeScheme = degreeScheme;
  }

  public void setForeName(String foreName) {
    this.foreName = foreName;
  }

  public String getForeName() {
    return foreName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public String getSurName() {
    return surName;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setDegreeScheme(String degreeScheme) {
    this.degreeScheme = degreeScheme;
  }

  public String getDegreeScheme() {
    return degreeScheme;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[foreName = " + foreName + " surName " + surName + " studentID "
        + studentID + " degreeScheme " + degreeScheme + "]";
  }

  public void format() {
    System.out.format("%5s%20s%11s%20s", foreName, surName, studentID, degreeScheme);
  }
}


class Registry {
  LinkedList<Student> studentList;

  public Registry() { // Creates studentList
    studentList = new LinkedList<>();
  }

  public void addStudent(Student aStudent) {
    studentList.add(aStudent);
  }

  public void deleteStudent(int studentID) {
    int index = searchList(studentID); // Gets index of the student in the Registry
    if (index == -1)
      throw new IllegalArgumentException("Student not found");
    // Since studentList is implemented as LinkedList, .remove removes element at specified position
    studentList.remove(index);
  }

  // Search by studentID , if found, return position in the list
  private int searchList(int studentID) {
    Iterator<Student> it = studentList.iterator();
    int count = -1;
    while (it.hasNext()) {
      count++;
      Student temp;
      temp = it.next();
      if (Integer.parseInt(temp.getStudentID()) == studentID) {
        return count;
      }
    }
    return -1;
  }

  @Override
  //Suggestions to improve the toString are welcome
  public String toString() {
    for (Student student : studentList) {
      student.format();
      System.out.println();

    }

    return "";
  }
}