import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        int rollNo = 0;
        String name;
        boolean valid = true;
        Scanner scan = new Scanner(System.in);
        while (true) {          
            do {
                System.out.print("Enter the roll no of the student: ");
                try {
                    rollNo = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("The value should be an integer.");
                    valid = false;
                }
            } while (!valid);
            System.out.print("Enter the name of the student: ");
            name = scan.nextLine();
            System.out.println("Roll no. " + rollNo + ", Name: " + name + " has been registered");
        }
    }
}