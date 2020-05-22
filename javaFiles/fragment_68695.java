ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Chris"));
students.add(new Student("John"));
students.add(new Student("Frank"));
students.add(new Student("Devon"));

Student me = new Student("Chris");
students.contains(me); // true