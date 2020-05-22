import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel p = new JPanel();

        MyMouseListener ml = new MyMouseListener(); // Only one MouseListener
        for (int i = 0; i < 8; i++) {
            JButton b = new JButton(String.valueOf(i));
            b.addMouseListener(ml); // Add the same MouseListener to every
                                    // button
            p.add(b);
        }
        frame.setContentPane(p);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public static class MyMouseListener implements MouseListener {

        Component firstEntered;
        Component lastEntered;

        @Override
        public void mouseClicked(MouseEvent event) {

        }

        @Override
        public void mouseEntered(MouseEvent event) {
            lastEntered = event.getComponent();
            System.out.println("entered : " + ((JButton) lastEntered).getText());
        }

        @Override
        public void mouseExited(MouseEvent event) {

        }

        @Override
        public void mousePressed(MouseEvent event) {
            firstEntered = event.getComponent();
            System.out.println("pressed : " + ((JButton) event.getComponent()).getText());
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            firstEntered.setBackground(Color.RED);
            lastEntered.setBackground(Color.BLUE);

            System.out.println("Release ... first: " + ((JButton) firstEntered).getText());
            System.out.println("Release ... last entered: " + ((JButton) lastEntered).getText());
        }
    }

}