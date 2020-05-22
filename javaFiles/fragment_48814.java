class Student{

    int age;

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {              // Called for instance when
        return "Student with age " + age;   // the student should be printed
    }
}