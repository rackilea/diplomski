import javax.swing.SwingUtilities;

public class TestTestWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestWindow.testWindow();
            System.out.println("Called after test window no longer visible");
        });
    }
}