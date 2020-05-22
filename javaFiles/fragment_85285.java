import java.util.Scanner;    

class InvalidDocumentCodeException extends RuntimeException {

    public InvalidDocumentCodeException(String s) {
        super(s);    
    }
}

public class Class113 {

    public static void main(String[] args) {
        // the try here is called try with resource
        // it will close the scanner at the end of the block.
        try(Scanner scan = new Scanner(System.in)){

            while(true){
                // Display a message to instruct the user
                System.out.println("Enter the designation: ");
                // Receive input
                String str = scan.next();

                if(str.equals("q")) break;

                try {
                    // Verify str is not null and make sure UCP are capital letters whens ubmitted
                    if (str.length() == 2 && (str.charAt(0) == 'U' || str.charAt(0) == 'C' || str.charAt(0) == 'P')) {
                        System.out.println("Valid designation");
                    } else{
                        throw new InvalidDocumentCodeException("Invalid designation. Designation must be two characters and start with U, C or P.");
                    }
                } catch(InvalidDocumentCodeException invalidDocError){
                    System.out.println(invalidDocError);
                }
            }
        }
    }
}