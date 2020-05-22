import java.util.Scanner;

public class Driver
{
    // static Scanner sc = new Scanner(System.in);
    // static int choice;
    // static Car[] driving = new Car[2];
    private Car[] driving = new Car[2];

    public Driver(){
        driving[0] = new Car();
        driving[1] = new Car();
    }

    public static void main(String args[]){
       Driver driver = new Driver();
       driver.changeSettings();
    }

    public void changeSettings(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the make");
        driving[0].setMake(sc.nextLine());
        System.out.println("Done.");
    }
}