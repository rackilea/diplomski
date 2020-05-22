import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface Engine {
        public void stop();
        public void start();
    }

    public class TestPane extends JPanel implements Engine {

        private Timer timer;
        private JLabel label = new JLabel("Waiting");

        public TestPane() {
            setLayout(new GridBagLayout());
            add(label);
            timer = new Timer(1000, new ActionListener() {
                private int counter = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    counter++;
                    label.setText(Integer.toString(counter));
                }
            });
            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "stop");
            actionMap.put("stop", new StopAction(this));

            start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void stop() {
            timer.stop();
            label.setText("Stopped");
        }

        @Override
        public void start() {
            timer.start();
        }

    }

    public class StopAction extends AbstractAction {

        private Engine engine;

        public StopAction(Engine engine) {
            this.engine = engine;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            engine.stop();
        }

    }

}