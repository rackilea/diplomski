import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class TestKeys {
    private HotkeyListener listener = new HotkeyListener() {
        @Override
        public void onHotKey(final int hotKeyId) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JIntellitype.getInstance().removeHotKeyListener(listener);
                    handleHotKey(hotKeyId);
                    JIntellitype.getInstance().addHotKeyListener(listener);
                }
            }).start();
        }
    };

    public void registerHotKeys() {
        JIntellitype instance = JIntellitype.getInstance();
        instance.registerHotKey(1, JIntellitype.MOD_CONTROL, 'Q');
        instance.registerHotKey(2, JIntellitype.MOD_CONTROL, 'J');
        instance.addHotKeyListener(listener);
        System.out.println("Hotkeys registered");
    }

    private static void handleHotKey(int hotKeyId) {
        switch(hotKeyId) {
            case 1:
                System.out.println("Pressing some keys now!");
                pressSomeKeys();
                break;
            case 2:
                System.out.println("Bailing out, cya!");
                System.exit(0);
                break;
        }
    }

    private static void pressSomeKeys() {
        Robot r;
        try {
            r = new Robot();
        } 
        catch (AWTException e) {
            System.out.println("Creating robot failed");
            System.exit(2);
            return;
        }
        r.setAutoWaitForIdle(true);
        r.delay(150);
        r.waitForIdle();
        r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
        r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
        r.keyPress(KeyEvent.VK_SPACE); r.keyRelease(KeyEvent.VK_SPACE);
        r.keyPress(KeyEvent.VK_R); r.keyRelease(KeyEvent.VK_R);
        r.keyPress(KeyEvent.VK_O); r.keyRelease(KeyEvent.VK_O);
        r.keyPress(KeyEvent.VK_C); r.keyRelease(KeyEvent.VK_C);
        r.keyPress(KeyEvent.VK_K); r.keyRelease(KeyEvent.VK_K);
        r.keyPress(KeyEvent.VK_S); r.keyRelease(KeyEvent.VK_S);
    }

    public static synchronized void main(String[] args) {
        System.out.println("TestKeys started");
        TestKeys k = new TestKeys();
        k.registerHotKeys();
        try { 
            TestKeys.class.wait();
        } 
        catch (InterruptedException e) {
        }
    }
}