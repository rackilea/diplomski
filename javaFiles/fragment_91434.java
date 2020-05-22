import java.util.Scanner;

class Car { // Class names start with uppercase

    private int yearModel; //an int that holds the car's year model
    private String make; //references a string object that holds the make of the car
    private int speed; //an int that holds the car's speed.

    public int getYearModel() {
        return yearModel;
    }

    public String getMake(){ 
        return make; //This is the field of the particular object
    }

    public int getSpeed(){ 
        return speed;
    }

    public void accelerate() {
        speed = speed + 5;
    }

    public void brake() {
        speed = speed - 5;
    }

//    Scanner input = new Scanner(System.in); // Avoid IO-dependency in constuctor

    public Car(int yearModelGiven, String makeGiven){
        this.yearModel = yearModelGiven;
        this.make = makeGiven;
        this.speed = 0;
//        System.out.println("Please enter in the initial speed of the car:");
//        speed = input.nextInt();
    }

    // Overloaded constructor
    public Car(int yearModelGiven, String makeGiven, int speed){ // extra parameter
        this.yearModel = yearModelGiven;
        this.make = makeGiven;
        this.speed = speed;
    }

}

public class Application{

    public static void main(String [] args ) { //this is a main method

        Scanner input = new Scanner( System.in );  

        System.out.println("What is the vehicle year: ");
        int carYear; 
        carYear = input.nextInt();
        input.nextLine(); // This line will scan the rest of the line after the number: The linefeed.
        System.out.println("The vehicle year is " + carYear);

        System.out.println("What is the vehicle make: ");
        String carMake;
//        carMake = input.nextLine(); // nextLine() scans the rest of the line including the linefeed
// The above line will do the same as the below two:
        carMake = input.next();
        input.nextLine();
        System.out.println("The vehicle make is "+ carMake);

        System.out.println("Please enter in the initial speed of the car:");
        int speed = input.nextInt();
        input.nextLine(); // This line will scan the rest of the line after the number: The linefeed.

//        Car car1 = new Car(carYear, carMake);  // will give it default speed 0
        Car car1 = new Car(carYear, carMake, speed); // will give it the speed entered by user.

        System.out.println( "Accelerating the vehicle now:" );  
        for( int seconds = 1; seconds <= 5; seconds++ ) {
            car1.accelerate();
            System.out.println( "The current speed of the" + " " + car1.getYearModel() + " " + car1.getMake() + " is " +
                      car1.getSpeed() + " km/h" );
        }

        // This is now the braking method
        System.out.println( "Braking the vehicle now:" );
        for (int seconds = 1; seconds <= 5; seconds++ ) {
             car1.brake();
             System.out.println( "The current speed of the" + " " + car1.getYearModel() + " " + car1.getMake() + " is " +
                      car1.getSpeed() + " km/h" );
        }
    }
}