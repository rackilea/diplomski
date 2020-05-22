public class Test2 {
    static Boolean bool=true;
    public static void main(String[] args){
        System.out.println("Type Y or N:");
        //Initialise the scanner object for the first time
        //Save what the user inputs as s
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        //Now you enter a while loop
        //You will quit this loop if a condition is met
        //If you want to you can set the bool to false and the while loop will end
        while (bool){
            //if what the user entered is not equal to Y or N
            //then prompt him to try again
            if (!s.equals("Y") && !s.equals("N")){
                System.out.println("Please type only Y or N:");
                sc = new Scanner(System.in);
                s=sc.next();

            }
            //if the user actually entered Y
            if (s.equals("Y")){
                //Do your code logic here
                //In your case that is saving your object
                //Then you can exit the program if that's what you want
                System.exit(1);

            }
            if (s.equals("N")){
                //Add code logic if the user enters N if you need to
                //Exit the program if that's what you want
                System.exit(1);         
            }
        }                       
    }
}