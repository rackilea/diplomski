import java.util.Scanner;

public class EP55Out {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);    
        System.out.print("Please enter a grade: ");
        String letter = in.next();
        //You need to give letter to the method
        getNumericGrade(letter);
    }

    //AND the method should need String and not double 
    public static void getNumericGrade(String letter){      
    //After this you need a real double value - lets call is grade;
        double grade = 0;
        int spacer = 0;
        String first = letter.substring(0,1);
        String second = letter.substring(1,2);

        //You cant to numeric stuff with a String- thats why we use our double here
        if (first.equalsIgnoreCase("a"))
        grade = 4.0;
        else if (first.equalsIgnoreCase("b"))
        grade = 3.0;
        else if (first.equalsIgnoreCase("c"))
        grade = 2.0;
        else if (first.equalsIgnoreCase("d"))
        grade = 1.0;
        else if (first.equalsIgnoreCase("f"))
        grade = 0;
        else grade = 9;

        if (second.equalsIgnoreCase("+"))
        grade += 0.3;
        else if (second.equalsIgnoreCase("-"))
        grade -= 0.3;
        else
        grade += 9;
        System.out.println(grade+"");
    }
}