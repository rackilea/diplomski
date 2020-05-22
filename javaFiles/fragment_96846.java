import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                TestPane tp = new TestPane();
                frame.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        tp.resume();
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        tp.pause(true);
                    }
                });
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private boolean aPressed = false;
        private Timer timer;

        public TestPane() {
            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "A.pressed");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "A.released");
            actionMap.put("A.pressed", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    aPressed = true;
                }
            });
            actionMap.put("A.released", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    aPressed = false;
                }
            });

            timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("A pressed = " + aPressed);
                }
            });
        }

        public void resume() {
            timer.restart();
        }

        public void pause(boolean reset) {
            timer.stop();
            if (reset) {
                aPressed = false;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}