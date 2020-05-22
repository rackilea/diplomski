//import java.util.scanner;
import java.util.*;

public class student
{
    public static void main (String args [])
    {
        Scanner grade = new Scanner(System.in);
        int studentgrade=0;
        int studentid=0;
        String studentname="";

        System.out.println("enter student grade");
        studentgrade = grade.nextInt(); // the error is here apparently ? it highlights this line yellow and says ";" expected

        System.out.println("enter your studentID here");
        studentid = grade.nextInt();

        System.out.println("type your student name here");
        studentname = grade.next();

        int answer = studentgrade + studentid;

        System.out.println("answer = " + answer + "student name = " + studentname);
        //+ student name    
    }
}