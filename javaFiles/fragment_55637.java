import java.awt.*;
import java.util.*;
import java.lang.reflect.Field;
import java.awt.event.*;
import javax.swing.*;

public class RobotCharacter
{
    public static void main(String[] args)
        throws Exception
    {
        JTextField textField = new JTextField(10);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( textField );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

        Robot robot = new Robot();
        typeCharacter(robot, "a");
        typeCharacter(robot, "b");
        typeCharacter(robot, "C");
        typeCharacter(robot, "D");
     }

    public static void typeCharacter(Robot robot, String letter)
    {
        try
        {
            boolean upperCase = Character.isUpperCase( letter.charAt(0) );
            String variableName = "VK_" + letter.toUpperCase();

            Class clazz = KeyEvent.class;
            Field field = clazz.getField( variableName );
            int keyCode = field.getInt(null);

            robot.delay(1000);

            if (upperCase) robot.keyPress( KeyEvent.VK_SHIFT );

            robot.keyPress( keyCode );
            robot.keyRelease( keyCode );

            if (upperCase) robot.keyRelease( KeyEvent.VK_SHIFT );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}