import java.util.Scanner;

public class main {

public static void main(String[] args) {
    /// take input
    String userInput = "";
    Scanner sc = new Scanner(System.in);
    userInput = sc.nextLine();
    int input ;
    // validation test
    if(userInput.length() == 5) {
        input = Integer.parseInt(userInput);
    }else {
        // you can display an error message to user telling him that he should enter 5 numbers!
    }
}

}