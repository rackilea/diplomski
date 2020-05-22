public static void main(String[] args) {
    Student[] studentArr = new Student[]{new Student("Mike"),new Student("Hector"), new Student("Reggie"),new Student("zark")};
    List<Student> students = new ArrayList<Student>(Arrays.asList(studentArr));
    Collections.sort(students, Student.getCompByName());

    for(Student student:students){
        System.out.println(student.getName());
    }
}