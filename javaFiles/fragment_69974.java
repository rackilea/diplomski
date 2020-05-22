public class UserTest {    
    public static void main(String[] args) {
        User user = new User();
        user.promptUserAge();
        user.printUserAge(user.getUserAge());
        //DO something.
        user.printUserAge(user.getUserAge());
        user.promptUserAge();
        user.printUserAge(user.getUserAge());
    }
}

public class User {
    private int userAge = 0;

    public void promptUserAge() {
        String userInput = AppUtils.promptUserInput("Enter Age: ");
        userAge = new Integer(userInput);
    }

    public int getUserAge(){
        return userAge;
    }

    public void printUserAge(int age){
        System.out.print("\nYou're " + age + " years of age.");
    }
}

public class AppUtils {
    public static String promptUserInput(String message) {
        Scanner input = new Scanner(System.in); 
        System.out.println(message);
        String userInput = input.next();
        return userInput;
    }
}