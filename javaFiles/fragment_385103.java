class Student{
  private int id;
    //remaining member variables 

    Student(int id){
        this.id = id;
    }



}



ArrayList<Student> students=new ArrayList<Student>();
Student student;
for(int  i=0;i<20;i++) {
    student=new Student(i+1);
    students.add(student);
}

//This will print student details;
for(int z=0;z<student.size();z++){
System.out.println("Student "+student[i].getId());
}