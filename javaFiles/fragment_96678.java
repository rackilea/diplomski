import java.util.Scanner; 

public class GradeData{
    public static void main(String[] args){
        double grade = 0;
        String name;
        String enterAgain;
        boolean enter = true; //to use in while loop
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = userInput.nextLine();
        System.out.println("Please enter a grade: ");
        grade = userInput.nextDouble(); 
        userInput.nextLine() //add this to your program
        System.out.println("Would you like to continue entering grades? (y/n)");
    enterAgain = userInput.nextLine(); 

        while(enter){
            if(enterAgain.equalsIgnoreCase("y")){
                System.out.println("Please enter another grade: ");
                /*enterAgain = userInput.nextLine() - we want user to input 
                a double grade, not a String*/
                grade = userInput.nextDouble();
            }
            else if(enterAgain.equalsIgnoreCase("n")){
                System.out.println("Ok. Don't enter more grades.");
                break; 
            }
            else{
                System.out.println("Sorry, you can only enter (y/n)");
                break; 
            }
        }
    }
}