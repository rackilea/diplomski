import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BadButton01 {

    public static void main(String[] args) {
        new BadButton01();
    }

    public BadButton01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public static class GameState {

        private static boolean isComplete;

        public static boolean getIfComplete() {
            return isComplete;
        }

        public static void setComplete(boolean value) {
            isComplete = value;
        }

    }

    public class TestPane extends JPanel {

        private RoundButton[] btns = new RoundButton[]
        {
            new RoundButton("1"),
            new RoundButton("2"),
            new RoundButton("3"),
            new RoundButton("4"),
            new RoundButton("5"),
            new RoundButton("6"),
            new RoundButton("7"),
            new RoundButton("8"),
            new RoundButton("9")
        };

        public TestPane() {
            setLayout(new GridLayout(3, 3));
            for (RoundButton btn : btns) {
                add(btn);
            }
            btns[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameState.setComplete(true);
                    btns[0].setBackground(Color.WHITE);
                    btns[1].setBackground(Color.WHITE);
                    btns[2].setBackground(Color.WHITE);
                    repaint();
                }
            });
        }

    }

    public class RoundButton extends JButton {

        public RoundButton(String label) {
            super(label);
            this.setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            Dimension size = this.getPreferredSize();
            size.height = size.width = Math.max(size.height, size.width);
            this.setPreferredSize(size);
            setBackground(Color.GREEN);
        }

        @Override
        protected void paintComponent(Graphics g) {
//            if (!GameState.getIfComplete()) { // If the game is not complete or has just started
//                this.setBorder(null);
//                g.setColor(Color.BLACK);
//                g.fillRect(0, 0, this.getSize().width, this.getSize().height);
                if (this.getModel().isArmed()) {
                    g.setColor(Color.RED);
                } else {
//                    g.setColor(Color.GREEN);
                    g.setColor(getBackground());
                }
//            } else {
//                this.setBorder(null);
//                g.setColor(Color.BLACK);
//                g.fillRect(0, 0, this.getSize().width, this.getSize().height);
//                g.setColor(Color.WHITE);
//                g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1);
//                g.setColor(getBackground());
//            }
            g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1);
            super.paintComponent(g);
        }

    }

}