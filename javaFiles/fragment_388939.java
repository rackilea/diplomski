import java.util.Scanner;

public class ExceptionTest {

    public static void exception(String name) {

        if (name.equals("Abudi")) {
            System.out.println("Your " + name + " is not allowed to proceed");
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //exception1(sc.next());
        String name;
        System.out.print("Enter your name here: "); 
        name = sc.nextLine();

        exception(name);
        sc.close();
    }
}