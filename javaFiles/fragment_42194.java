import java.util.Random;

public class PasswordRandomizer {
    // Define the variables
    private int length;
    private String password;
    private Random random = new Random();
    private char symbol;

    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.length = length;
    }

    public String createPassword() {
        // write code that returns a randomized password
        password = "";
        while (this.password.length() < this.length) {
            this.symbol = "abcdefghijklmnopqrstuvwxyz".charAt(this.random.nextInt(26));
            this.password += symbol;
        }
        return this.password;
    }

}