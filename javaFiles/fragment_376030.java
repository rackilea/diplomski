public class StudentInfo {
    static Student[] students;
    static int maxStudentNumber;

    public static void main(String[] args) {

        maxStudentNumber = 5;
        addStudents();

        printStudents();

        System.out.println ("The maximum amount of students per class is: " + maxStudentNumber +"" );
    }

    static void addStudents() {

        students = new Student[maxStudentNumber];
        students[0] = new Student ("Mike" , 40);
        students[1] = new Student ("Tom" , 50);
        students[2] = new Student ("John" , 60);
        students[3] = new Student ("May" , 80);
        students[4] = new Student ("Lucy" , 50);
    }
    static void printStudents() {
        for(int i=0;i<maxStudentNumber;i++) {
            students[i].greeting();
        }
    }
}