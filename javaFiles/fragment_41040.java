class Student{
    private String name;

    Student(){
        name = ""; // initialization
    }

    String getName(){
        return name;
    }

    void setName(String n){
        name = n;
    }

    void somemethod(){ // or any other return type and parameters
        ...
    }
}

public class Main{
    Student[] student = new Student[10];
    student[0] = new Student();
    student[1] = new Student();
    ...
    student[0].setName("TOMATO");
    student[1].setName("POTATO"); 
    ...
    for(Student s : student) {
        if(s != null && s.getName.equal("POTATO")) {
            s.somemethod();// call on s
        }
    }
}