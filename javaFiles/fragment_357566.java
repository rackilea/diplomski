package ForNewFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

class RobotClass {

    Robot robot = new Robot(); // Robot class throws AWT Exception

    public static void main(String[] args) throws AWTException, InterruptedException {
        // WebDriver driver = new FirefoxDriver();
        new RobotClass().runWindows("\\\\18.187.980.12\\\\Logs\\\\abc.log");
    }


    public RobotClass() throws AWTException, InterruptedException {

    }

    public void runWindows(String run) throws InterruptedException{

        robot.keyPress(KeyEvent.VK_WINDOWS); // press arrow down key of keyboard
        robot.keyPress(KeyEvent.VK_R); // press arrow down key of keyboard to
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        type(run);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    private void type(String s) throws InterruptedException  {
        Thread.sleep(2000); 
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
          int code = b;
          // keycode only handles [A-Z] (which is ASCII decimal [65-90])
          if (code >=65 && code<=90){
              System.out.println(code);
              robot.delay(1000);
              robot.keyPress(KeyEvent.VK_SHIFT );

              robot.keyPress(code);
              robot.keyRelease(code);
              robot.keyRelease(KeyEvent.VK_SHIFT);


          }else if (code > 96 && code < 123) {
              code = code - 32;
              System.out.println(code);
              robot.delay(2000);
              robot.keyPress(code);
              robot.keyRelease(code);
          }
          else{
              robot.delay(2000);
              robot.keyPress(code);
              robot.keyRelease(code);
          }

        }
}
}