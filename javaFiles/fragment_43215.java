import java.util.Scanner;

    public class NegativeNumberException extends Exception{

        NegativeNumberException(){
            System.out.println(exceptionMessage);
        }

        String exceptionMessage = "Number must be positive";
        static int num;

        public static void main(String[] args) throws NegativeNumberException{

            try
            {
            if(Integer.parseInt(args[0])<0){
                throw new NegativeNumberException();
            }
            else{
                 int num = Integer.parseInt(args[0]);
                 System.out.println("Your number is: " + num);

            }
            }
            catch(NumberFormatException ex){
                System.out.println("That's not even a number.");

            }
            catch(NegativeNumberException ex){
                ex.getMessage();
            }



            while(num==0){
            try{
                System.out.println("Enter a positive number:");
                Scanner input = new Scanner(System.in);
                int num1 = input.nextInt();
                if(num1<0){
                    throw new NegativeNumberException();
                }
                num = num1;
                break;
            }catch(Exception ex){
                System.out.println("Positive number only, try again...");
                }
            }//End While

            System.out.println("Your number is:" + num);
            }

    }