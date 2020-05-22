import javax.swing.SwingUtilities;

public class Test {

    private static FrameTest f;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f = new FrameTest();
                f.mainScreen();
            }
        });
    }

    void buttonPress() {
        f.writeLabel("Hello");
    }
}