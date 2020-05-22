/**
 * Created by Ninan John J P on 6/30/2016.
 */
import java.util.Scanner;

public class JavaApplication62 {

    public static void main(String[] args) {

        while (true) {

            Scanner in = new Scanner(System.in);

            System.out.println("1.Enroll Student");
            System.out.println("2.Offer Course");

            //String name = in.next(); Not required. This will want a text input before proceeding further.
            int choice = in.nextInt();

            if (choice == 1) {

                student_class[] studentList = new student_class[500];

                studentList[0] = new student_class();

                while (true) {

                    System.out.print(" Enter name of the student: ");
                    studentList[0].setName(in.next());

                    System.out.println("");
                    System.out.print(" The student is given the unique ID =  " + studentList[0].getUniqueStudentID() + " and the number of students =  " + studentList[0].getNumberOfStudents());

                   /* System.out.print("> and the number of students :  ");
                    //studentList[0].setnumberOfStudents(in.nextInt);
                    studentList[0].setNumberOfStudents(in.nextInt());
                   */ //This is not required. You have already done this in the previous print statment.

                    System.out.println("");
                    System.out.print(" Enter the e-mail address of the student: ");
                    //studentList[0].setemail(in.next); you are calling the wrong method. Also in.next should be a method.
                    studentList[0].setEmail(in.next());

                    System.out.print("Enter the semester number of the student:  ");
                   // studentList[0].setsemesterNumber(in.nextInt); // same as prev error

                    studentList[0].setSemesterNumber(in.nextInt());

                    System.out.print(" Add another student (Y/N): ");
                    char add = in.next().charAt(0);
                    if (add == 'Y' || add == 'y') {

                    }

                    if (add == 'N' || add == 'n') {
                        break;
                    }

                }

            } else if (choice == 2) {

                while (true) {

                    Course[] courseOfferedList;
                    courseOfferedList = new Course[500];
                    courseOfferedList[0] = new Course();

                    System.out.println("Enter the course code : ");
                    //courseOfferedList[0].setCourseCode(in.next()); // next() returns a string. You need nextInt() here.   

                    courseOfferedList[0].setCourseCode(in.nextInt());

                    System.out.println(" Enter the course title: ");
                    courseOfferedList[0].setCourseTitl(in.next());

                    System.out.println(" Enter the credit hours of the course: ");
                    courseOfferedList[0].setCreditHours(in.nextInt());

                    System.out.print(" Add another course (Y/N): ");
                    char add2 = in.next().charAt(0);

//                    if (add2 == 'Y' || add2 == 'y') { // not needed
//                    }

                    if (add2 == 'N' || add2 == 'n') {
                        break;
                    }

                }

            }

        }
    }

}