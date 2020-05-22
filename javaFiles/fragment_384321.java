import org.apache.commons.validator.*;
    public class main {
        public static void main(String[] args) {
            String email = "example@gmail.com";

            EmailValidator emailvalidator = EmailValidator.getInstance();

            if(emailvalidator.isValid(email)) {
                System.out.println("Email is valid");
            } else {
                System.out.println("Email is invalid");
            }
        }
    }