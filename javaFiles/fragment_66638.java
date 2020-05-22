import java.io.*;

public class sort {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws IOException{
    // TODO code application logic here
    //Declare BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //declare variables
    int x=0, y=0;
    double grade=0.0;
    String course;

    //ask user how many courses they completed
    System.out.println("How many courses have you completed?");
    //obtain answer
    int completed=Integer.parseInt(br.readLine());

    //declare array for course
    String courses[]=new String[completed];

    //ask user to enter the course names use a FOR loop for this
    for(int i=0;i<courses.length;i++)
    {            
        System.out.println("Please enter course name " + (i+1));
        course = br.readLine(); 
        System.out.println("What is the grade you got for " + course);
        //get their answer
        grade = Double.parseDouble(br.readLine());

    //end for loop

    //display to the user the high achievement award qualifiers:

    System.out.println("High-Ahcievement Award Qualifiers: \n");
    if(grade>93)
    {
        //output
    }
    else if(grade<70)
    {
        System.out.println("Needs Improvement:");
        //output
    }
    }
}
}