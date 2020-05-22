List<Student> students = new ArrayList<Student>();
int numberOfStudents = 3;

for (int i = 0; i < numberOfStudents; i++){
    System.out.println("Please enter name:");
    String name = sc.nextLine();

    System.out.println("Please enter year:");
    Integer year = sc.nextInt();

    /* after gathering the input create student */
    Student s = new Student();
    s.setName(name);
    s.setYear(year);

    students.add(s);
}