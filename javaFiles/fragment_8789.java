package karel;
import kareltherobot.*;
import kareltherobot.Directions;
import kareltherobot.World;
public class KarelSample implements Directions
{
    public static void main(String [] args)  
    {
        new Karelrunner(8,8,South,2); 

        UrRobot Karel = new UrRobot (1,3,North,2);

        Karel.move();
        Karel.move();
        Karel.putBeeper();
        Karel.move();
        Karel.turnLeft();
        Karel.move();
    }   

    static
    {   
        World.setVisible(true);
        World.showSpeedControl(true);
    }
}

class Karelrunner extends UrRobot implements Directions 
{
    public Karelrunner (int street, int avenue, Direction direction, int beepers)
    { 
        super ( street, avenue, direction, beepers);
        World.setupThread(this);
    }

    public void run()
    {
        move();
        move();
        putBeeper();
        turnLeft();
        move();
    }
}