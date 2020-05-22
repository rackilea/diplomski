import java.util.Scanner;
public final class NameIsAgeLauncher {
private NameIsAgeLauncher() 
{
}
public static void main(String[] args) {
    String userName = null;
    int userAge = 0;
    Scanner stdIn = new Scanner(System.in);
    System.out.println("Enter your name: "); //Prompts user to enter name.
    userName = stdIn.nextLine(); //Name from Practice should be equal to what the user enters.
    System.out.println("Enter your age: "); //Prompts user to enter name.
    userAge = stdIn.nextInt(); //Name from Practice should be equal to what the user enters.
    NameIsAge blah = new NameIsAge(userName, userAge);

    NameIsAge halb = new NameIsAge ("Campbell", 97);
    halb.setUserName("Campbell");
    halb.setUserAge (97);
    System.out.println(blah.userName + " is " + blah.userAge + ".");
    System.out.println(halb.userName + " is " + halb.userAge + ".");
}   
}