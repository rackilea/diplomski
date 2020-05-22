import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Application extends JFrame {

    private static final long serialVersionUID = 1L;

    public Application() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(new JButton("Button"));
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(jPanel);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Application().setVisible(true);
            }
        });
    }
}