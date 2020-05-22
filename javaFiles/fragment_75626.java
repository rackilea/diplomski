class Students{
  private static ArrayList<Student> STUDENTS = new ArrayList<>();
  public static void addStudents(Student student){
    STUDENTS.add(student);
  }

  // Factory method.
  public static Student createAndAddStudent(String name, int birthYear) {
    Student student = new Student(name, birthYear);
    addStudents(student);
    return student;
  }
}