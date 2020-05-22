import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GUI extends JFrame {

    private boolean open;
    JPanel pane;
    JLabel windowState;
    int count = 1;

    public GUI() {

        int numberOfRows = 9;
        int numberOfColumns = 2;
        pane = new JPanel(new BorderLayout());
        pane.setLayout(new GridLayout(numberOfRows, numberOfColumns));

        String wState;
        if (open) {
            wState = "Window open";
        } else {
            wState = "Window closed";
        }

        windowState = new JLabel(wState);
        pane.add(windowState);

        add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        new Timer(500, new WindowState()).start();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }

    private class WindowState implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            count++;
            windowState.setText("Number " + count + "!");
        }
    }
}