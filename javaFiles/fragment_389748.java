import java.util.Scanner;
public class Prog3 {

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Robot robo = new Robot();

    //asks the user for robots name
    System.out.print("Enter robots name: ");
    String myName = in.next();
    robo.setName(myName);


    while( true ){
    //asks the user to move the robot
    System.out.print("Direction of move (x/y/q): ");
    String direction = in.next();
    if(direction.equals("q"))
        break;

    System.out.println("Distance of move: ");
    int distance = in.nextInt();


    if (direction.equals("x")) {
        robo.moveX(distance);
        System.out.println("moved" + distance +"units along the x axis");
    }
    else if (direction.equals("y")) {
        robo.moveY(distance);
        System.out.println("moved " + distance +" units along the y axis");
    }
    else {
        System.out.println("error");
    }
    }

    System.out.println("moved " + robo.getTotalDistance() + " total distance");

}
}