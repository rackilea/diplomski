import java.awt.DisplayMode;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class kiosk {
  public static void main(String[] args) {
    try {
      // Screens
      int ScreenID = 0;
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice[] gs = ge.getScreenDevices();
      for(GraphicsDevice curGs : gs) {

        // Get the Displays
        DisplayMode dm = curGs.getDisplayMode();
        int x = dm.getWidth();
        System.out.println(ScreenID + " :" + dm.getWidth() + " x " + dm.getHeight());

        // Burst fire now
        Robot robot = new Robot();
        robot.setAutoDelay(500);
        if(ScreenID>0) {         
          robot.mouseMove(1280 + (x/13), 70);
        } else {
          robot.mouseMove(x/13, 70);
        }
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);   
        ScreenID++;

      }            

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}