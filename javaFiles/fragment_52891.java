import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Tester {
    public static void doLeftMouseClick(Robot r, int x, int y) {
        r.mouseMove(x, y);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void doLeftMouseClickEvent(Robot r, int x, int y, int nr) {
        r.mouseMove(x, y);
        if (nr == 1)
            r.mousePress(InputEvent.BUTTON1_MASK);
        else
            r.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void main(String args[]) throws Exception {
        Robot r = new Robot();
        doLeftMouseClick(r, 272, 241);
        r.delay(1000);
        doLeftMouseClick(r, 272, 241);
        r.keyPress(KeyEvent.SHIFT_MASK);
        doLeftMouseClickEvent(r, 272, 241, 1);
        doLeftMouseClickEvent(r, 529, 242, 2);
        r.keyRelease(KeyEvent.SHIFT_MASK);
        r.keyPress(KeyEvent.CTRL_MASK);
        r.keyPress(KeyEvent.VK_C);
        r.keyRelease(KeyEvent.CTRL_MASK);
        // etc.
    }
}