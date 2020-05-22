import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(new Dimension(410, 330));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setBounds(50, 50, 300, 200);

        panel.addKeyListener(new MyKeyListener()); // add KeyListener
        panel.setFocusable(true); // set focusable to true
        panel.requestFocusInWindow(); // request focus

        f.getContentPane().add(panel);
        f.setVisible(true);
    }

    static class MyKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '\177') {
                // delete row method (when "delete" is typed)
                System.out.println("Key \"Delete\" Typed");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                // delete row method (when "delete" is pressed)
                System.out.println("Key \"Delete\" Pressed");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                // delete row method (when "delete" is released)
                System.out.println("Key \"Delete\" Released");
            }
        }
    }
}