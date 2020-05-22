import java.util.List;
    import java.util.ArrayList;        
    ..
    List<Student> students = new ArrayList<Student>();

    Student s = new Student();
    s.setName("Joe");
    students.add(s);

    Student t = new Student();
    t.setName("Jack");
    students.add(t);

    for(Student student : students) {
        System.out.println(student.toString());
    }