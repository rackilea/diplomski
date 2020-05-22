import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

private Robot robot;

public void login(String login, String password) {
    copyValueFromClipboardToInput(login);
    getRobot().keyPress(KeyEvent.VK_TAB);
    getRobot().keyRelease(KeyEvent.VK_TAB);
    copyValueFromClipboardToInput(password);
    getRobot().keyPress(KeyEvent.VK_ENTER);
    getRobot().keyRelease(KeyEvent.VK_ENTER);
}

private void copyValueFromClipboardToInput(String value) {
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(value), null);
    getRobot().keyPress(KeyEvent.VK_CONTROL);
    getRobot().keyPress(KeyEvent.VK_V);
    getRobot().keyRelease(KeyEvent.VK_V);
    getRobot().keyRelease(KeyEvent.VK_CONTROL);
}

private Robot getRobot() {
    if (robot == null) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    return robot;
}