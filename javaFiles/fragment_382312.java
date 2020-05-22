import uk.ac.warwick.dcs.maze.logic.IRobot;
import java.util.ArrayList;
import java.util.*;

public class Explorer2 {

    private ArrayList<Integer> passageDirections = new ArrayList<Integer>();
    private ArrayList<Integer> nonWallDirections = new ArrayList<Integer>();
    private Random random = new Random();

    public void controlRobot (IRobot robot) {
        int exits = nonwallExits(robot);
        int direction;

        if (exits < 2) {
            direction = deadEnd(robot);
        } else if (exits == 2) {
            direction = corridor(robot);
        } else if (exits == 3) {
            direction = junction(robot);
        } else {
            direction = crossroads(robot);
        }

        robot.face(direction);

    }

    /*  Deadend method will make the robot turn around except from the beginning.
        Because the robot can face any direction at the start, it will follow
        the one and only passage it will detect. */
    public int deadEnd (IRobot robot) {

        if (passageExits(robot) == 0)
            return IRobot.BEHIND;
        else
            return -1; //FIXME: return correct direction!!!

    }


    /* Corridor method will make the robot follow the one and only passage. */
    public int corridor (IRobot robot) {

        return -1; //FIXME: return correct direction!!!

    }


    /* Junction method states if there is more than one passage, it will randomly select one.
        If there is no passage, it will randomly select a nonwall/BeenBefore direction. */
    public int junction(IRobot robot) {


        if (passageExits(robot) >= 1) {
            int randomPassage = random.nextInt(passageDirections.size());
            return passageDirections.get(randomPassage);
        } else {
            int randomNonwall = random.nextInt(nonWallDirections.size());
            return nonWallDirections.get(randomNonwall);
        }

    }


    /* Crossroads method states if there is more than one passage, it will randomly select one.
        If there is no passage, it will randomly select a nonwall/BeenBefore direction. */
    public int crossroads (IRobot robot) {

        if (passageExits(robot) >= 1) {

            int randomPassage = random.nextInt(passageDirections.size());
            return passageDirections.get(randomPassage);
        } else {
            int randomNonwall = random.nextInt(nonWallDirections.size());
            return nonWallDirections.get(randomNonwall);
        }
    }


    //Calculates number of exits and stores the direction of the exits in an ArrayList
    private int nonwallExits (IRobot robot) {

        int nonwallExits = 4;

        if(robot.look(IRobot.AHEAD) == IRobot.WALL)
            nonwallExits--;
        if(robot.look(IRobot.LEFT) == IRobot.WALL)
            nonwallExits--;
        if(robot.look(IRobot.RIGHT) == IRobot.WALL)
            nonwallExits--;
        if(robot.look(IRobot.BEHIND) == IRobot.WALL)
            nonwallExits--;

        for(int direction = IRobot.AHEAD; direction < IRobot.LEFT; direction++) {
            if(robot.look(direction) != IRobot.PASSAGE)
                nonWallDirections.add(direction);
        }

        return nonwallExits;
    }


    //Calculates number of passages and stores the direction of the passages in an ArrayList
    private int passageExits (IRobot robot) {

        int passageExits = 0;

        if(robot.look(IRobot.AHEAD) == IRobot.PASSAGE)
            passageExits++;
        if(robot.look(IRobot.LEFT) == IRobot.PASSAGE)
            passageExits++;
        if(robot.look(IRobot.RIGHT) == IRobot.PASSAGE)
            passageExits++;

        for(int direction = IRobot.AHEAD; direction < IRobot.LEFT; direction++) {
            if(robot.look(direction) == IRobot.PASSAGE)
                passageDirections.add(direction);
        }

        return passageExits;
    }
}