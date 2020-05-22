public class Interpretator {

    MyFirstRobot robot;

    public Interpretator(MyFirstRobot robot_arg) {
        // constructor sets instance variable
        robot = robot_arg;
    }

    public void onScan() {
        robot.fire(1); // use reference
    }
}