import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String continueAdd = "y";
        List<Student> studentList = new ArrayList<>();

        Student student;
        while ("y".equalsIgnoreCase(continueAdd)) {
            student = new Student();
            System.out.println("Enter your last name:");
            student.lastName = scn.nextLine();
            System.out.println("Enter your first name:");
            student.firstName = scn.nextLine();
            System.out.println("Enter your course:");
            student.course = scn.nextLine();
            System.out.println("Enter your year:");
            student.year = scn.nextLine();

            studentList.add(student);

            System.out.println("Add More (y/n): ");
            continueAdd = scn.nextLine();
        }
        int i = 0;
        for(Student studentTemp : studentList){

            System.out.println("["+i+"] - " + studentTemp);
            i++;
        }

    }


}

class Student {
    String firstName;
    String lastName;
    String course;
    String year;

    @Override
    public String toString(){
        return lastName+" | "+ firstName +" | "+course+" | "+year;

    }

}