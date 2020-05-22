import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Example {

    JButton button = new JButton("Open");

    public static void main(String args[]) {

        new Example();

    }

    public Example() {

        JFrame frame = new JFrame();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new secondFrame();

            }
        });

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    class secondFrame extends JFrame implements WindowListener {

        public secondFrame() {

            setSize(200, 200);
            setVisible(true);

            addWindowListener(this);

        }

        @Override
        public void windowActivated(WindowEvent arg0) {

        }

        @Override
        public void windowClosed(WindowEvent arg0) {

        }

        @Override
        public void windowClosing(WindowEvent arg0) {

            button.setEnabled(true);

        }

        @Override
        public void windowDeactivated(WindowEvent arg0) {

        }

        @Override
        public void windowDeiconified(WindowEvent arg0) {

        }

        @Override
        public void windowIconified(WindowEvent arg0) {

        }

        @Override
        public void windowOpened(WindowEvent arg0) {

            button.setEnabled(false);

        }

    }

}