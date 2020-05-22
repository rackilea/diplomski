import java.awt.Robot;

public class Test{
    public static void main(String[] args)
        throws Exception
    {
        //time to switch to a specific window where the robot ought to be tested
        try{ Thread.sleep(2000); }catch(InterruptedException e){}

        Robot r = new Robot();
        for(int i = 0; i < 20; i++){
            //scroll and wait a bit to give the impression of smooth scrolling
            r.mouseWheel(1);
            try{ Thread.sleep(50); }catch(InterruptedException e){}
        }
    }
}