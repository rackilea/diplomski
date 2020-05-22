package org.sba.robotsend;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * This program simulates the typing of its arguments on Console keyboard.
 * Each argument is send via Robot to the console, followed by an Enter key
 * Ex : java -j RobotSend.jar "echo foo" "echo bar"  gives :
 *  c:\> echo foo
 *  foo
 *  c:\> echo bar
 *  bar
 *
 * It is intented to automate programs reading their input on the Console
 * 
 * @author serge.ballesta
 */
public class RobotSend {
    private Robot robot;
    private Charset cp850;
    private static final int[] keys = { KeyEvent.VK_NUMPAD0, KeyEvent.VK_NUMPAD1,
         KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4,
         KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD7,
         KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUMPAD9
    };

    /**
     * This program simulates the typing of its arguments on Console keyboard.
     * Each argument is send via Robot to the console, followed by an Enter key
     * Ex : java -j RobotSend.jar "echo foo" "echo bar"  gives :
     *  c:\> echo foo
     *  foo
     *  c:\> echo bar
     *  bar
     *
     * It is intented to automate programs reading their input on the Console
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RobotSend robot = new RobotSend();

        try {
            robot.run(args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) throws AWTException {
        robot = new Robot();
        cp850 = Charset.forName("IBM850");
        for (String str: args) {
            sendString(str);
        }
    }

    /**
     * Send a byte using the Alt xyz sequence.
     * the byte must be in CP850 code page, indipendently of the actual code
     * page of the console (at least for System natively in CP850 ...)
     * @param c the byte (char) to be inputted via keyboard
     */
    public void sendByte(byte c) {
            int i = (int) c;
            if (i < 0) { i = 256 + i; }
            if (i < 0  || i > 255) { i = 'X'; }
            int i1 = i / 100;
            int i2 = (i % 100) / 10;
            int i3 = i % 10;
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(keys[i1]);
            robot.keyRelease(keys[i1]);
            robot.keyPress(keys[i2]);
            robot.keyRelease(keys[i2]);
            robot.keyPress(keys[i3]);
            robot.keyRelease(keys[i3]);
            robot.keyRelease(KeyEvent.VK_ALT);
    }

    /**
     * Simulate a Enter
     */
    public void sendEnter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * Send a String via the Console keyboard.
     * The string is first encoded in CP850, sent one char at a time via sendByte
     * and followed by an Enter key
     * @param str 
     */
    public void sendString(String str) {
        ByteBuffer buf = cp850.encode(str);
        for (byte b: buf.array()) {
            sendByte(b);
        }
        sendEnter();
    }
}