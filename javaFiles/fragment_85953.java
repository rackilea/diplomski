import java.awt.*;
import javax.swing.*;

public class WindowTest {

    private JFrame frame;

    public JPanel createContentPane() {
        JTextField text = new JTextField("Whatewer");        
        JPanel panel = new JPanel();
        panel.add(text);
        createAndShowWindow();
        return panel;
    }

    void createAndShowGUI() {
        frame = new JFrame("Window Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(createContentPane());
        frame.setLocation(50, 50);
        frame.pack();
        frame.setVisible(true);
    }

    private void createAndShowWindow() {
        JTextField text = new JTextField("Whatewer");
        JWindow win = new JWindow(frame);
        win.setLayout(new GridLayout(0, 1));
        win.add(text);
        win.pack();
        win.setLocation(150, 50);
        win.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new WindowTest().createAndShowGUI();
            }
        });
    }
}