public class Course{
public void addStudent(Student student){
this.students.add(student);
student.getCourses().add(this);
}
}

public class Student{
public void addCourse(Course course){
this.courses.add(course);
course.students.add(this);
}
}