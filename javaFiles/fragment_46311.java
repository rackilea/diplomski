import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

    public class ButtonPressDemo {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    initGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void initGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // add your buttons
        contentPane.add(new JButton("A"));
        contentPane.add(new JButton("B"));
        contentPane.add(new JButton("C"));

        contentPane.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int keyPressed = e.getKeyCode();
                System.out.println("pressed key: "+keyPressed);
                // do something ...
            }
        });
        contentPane.setFocusable(true); // panel with keyListener must be focusable
        frame.setContentPane(contentPane);
        contentPane.requestFocusInWindow(); // panel with key listener must have focus
        frame.setVisible(true);
    }
}