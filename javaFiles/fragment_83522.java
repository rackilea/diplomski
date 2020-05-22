import java.util.Scanner;

class Main{
    public static void main(String args[]) {
        int rollNo;
        String name;
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.print("Enter the roll no of the student: ");
            rollNo=scan.nextInt();
            System.out.print("Enter the name of the student: ");
            name=scan.nextLine();
            System.out.printf("Roll no. %d, Name: %s has been registered%n",rollNo, name);
        }
    }
}