while (sc.hasNextLine()) { 
//read first line from file 
name = sc.nextLine();
age = sc.nextLine();
gpa = sc.nextLine();

Student newStudent = new Student(name, age, gpa); //deal with age and gpa parsing inside Student constructor

students.add(newStudent); 

System.out.printf("%s %s %s \n", name, age, gpa);
//should print the same as
System.out.printf("%s %d %f \n", newStudent.name, newStudent.age, newStudent.gpa);

}