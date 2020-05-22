package Chapter2_Arrays;
import java.util.*;
public class Arrays_ExTwo {

    static final int numberOfSubjects=2;
    static final int numberOfStudents=4;

    // byte is a number from -128 to 127; that's big enough for 1-6 marks; you can use char for 'A'-'F' marks.
    static byte [][] marks=new byte[numberOfSubjects][numberOfStudents];

    static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Welcome to Cincinnati Elementary");
        System.out.println("There are "+ " "+ numberOfSubjects+ " "+ "subjects being taught");
        System.out.println("There are "+" "+numberOfStudents+" "+" number of students in the class");

        for(int i=0;i<numberOfSubjects;i++)
        {
            System.out.println("Enter the marks of students for subject no. "+(i+1)+":");
            for(int j=0;j<numberOfStudents;j++)
            {
                marks[i][j]=in.nextByte();
                System.out.println("Mark of student no. " + (j+1) + " for subject no. " + (i+1) + "was set to " + marks[i][j]);
            }
        }

    }

}