public class ProgressDial {

public static void main(String[] args) throws InterruptedException {

    if (args[0].equals("false")) {
        System.out.println("Args = false");
        System.exit(0);
    } else {
        while (args[0].equals("true")) {
            System.out.print("\\");
            Thread.sleep(500);
            System.out.print("\b ");
            System.out.print("\r");
            System.out.print("|");
            Thread.sleep(500);
            System.out.print("\b ");
            System.out.print("\r");
            System.out.print("/");
            Thread.sleep(500);
            System.out.print("\b ");
            System.out.print("\r");
            System.out.print("-");
            Thread.sleep(500);
            System.out.print("\b ");
            System.out.print("\r");
        }
    }
}