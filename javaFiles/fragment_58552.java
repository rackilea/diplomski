public static List<Student> populate(){
    Student s01 = new Student("David");
    s01.age = 12;
    s01.program = "Elementary School";


    Student s02 = new Student("Alex");
    s02.age = 5;
    s02.program = "Kindergarten";

    List<Student> students = new ArrayList<Student>();
    students.add(s01);
    students.add(s02);
    return students;
}