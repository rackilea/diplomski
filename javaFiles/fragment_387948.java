public class Junction {
    public final int juncX;
    public final int juncY;
    public final int arrivalHeading;

    public String toString() {
        return String.format("x = %d y = %d arrivalHeader = %d", juncX, juncY, arrivalHeading);
    }
}

public class RobotData {

    private List<Junction> junctions;

    RobotData() {
        this.junctions = new ArrayList<Junction>();
    }

    public void recordJunction(IRobot robot) {
        Junction junction = new Junction();    
        junction.juncX = robot.getLocation().x;
        junction.juncY = robot.getLocation().y;
        junction.arrivalHeading = robot.getHeading();
        junctions.add(junction);
    }
}