import org.apache.commons.validator.routines.EmailValidator;

public class TestMail {

public static void main(String[] args) {

    EmailValidator v = EmailValidator.getInstance();

    System.out.println(v.isValid("random@.com")); //false
    System.out.println(v.isValid("random.bla@gmail")); //false
}
}