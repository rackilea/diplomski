import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class Test {

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println(getPointerColor());
                Thread.sleep(1000);
            } catch (AWTException awte) {
                System.out.println("Error while getting pointer's color!");
            } catch (InterruptedException ie) {
                System.out.println("Error while sleeping!");
            }
        }
    }

    public static Color getPointerColor() throws AWTException {
        Point coordinates = MouseInfo.getPointerInfo().getLocation();
        Robot robot = new Robot();
        return robot.getPixelColor((int) coordinates.getX(), (int) coordinates.getX());
    }
}