public class Student {
  ....
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "school_id_fk")
  private School school;

}

public class School{
  ....
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
  private Set<Student> studentSet;

  // this is private setter (used by hibernate internally)
  private void setStudentSet(Set<Student> studentSet) {
    this.studentSet = studentSet;
  }

  // this is public method (exposed API)
  public void addStudent(Student) {
    if (studentSet == null) {
      studentSet = new HashSet<>();
    }

    student.setSchool(this);
    studentSet.add(student);
  }

}