import java.util.Scanner; 
public class PasswordVerification {

    public static void main(String[] args) {
        //      Creates a scanner
        Scanner sc = new Scanner(System.in);
        boolean valid = false; 
        String password;

        do { // start a loop
            //      Asks user to enter password
            System.out.print("Please enter password and then hit enter:");
            password = sc.nextLine(); 

            //      Checks to see if password is at least 8 characters. 
            if (password.length()<8) 
            {
                valid = false;
                System.out.println("Password must have at least 8 characters");
                continue; // skip to next iteration
            }

            //      Checks each character to see if it is acceptable.
            for (int i = 0; i < password.length(); i++){
                char c = password.charAt(i);

                if (       ('a' <= c && c <= 'z') // Checks if it is a lower case letter
                        || ('A' <= c && c <= 'Z') //Checks if it is an upper case letter
                        || ('0' <= c && c <= '9') //Checks to see if it is a digit
                ) 
                {

                    valid = true;
                }
                else 
                {
                    // tells the user that only letters & digits are allowed
                    System.out.println("Only letter & digits are acceptable.");
                    valid = false;
                    break;
                }

            }
        } while(!valid); // verify if the password is valid, if not repeat the process

        // if the password is valid, tell the user it's accepted
        System.out.println("Password Accepted");
    }


}