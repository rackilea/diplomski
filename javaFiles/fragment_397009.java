import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    public static class Blinker {
        private Color color1;
        private Timer timer;
        private Consumer<Color> setColor;
        private int timesBlinked;

        public Blinker(int delay, int blinkTimes, Color color1, Color color2, Consumer<Color> setColor) {
            this.color1 = color1;
            this.setColor = setColor;
            timesBlinked = 0;
            timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timesBlinked < blinkTimes) {
                        if (timesBlinked % 2 == 0)
                            setColor.accept(color2);
                        else
                            setColor.accept(color1);
                        ++timesBlinked;
                    }
                    else
                        stop();
                }
            });
        }

        private void stop() {
            timer.stop();
        }

        public void start() {
            setColor.accept(color1);
            timer.start();
        }
    }

    public static void startBlink(int delay, int blinkTimes, Color color1, Color color2, Consumer<Color> setColor) {
        new Blinker(delay, blinkTimes, color1, color2, setColor).start();
    }

    public static class YourJFrame extends JFrame {
        public YourJFrame(String title) {
            super(title);

            JButton button = new JButton("Choose color");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color bgC = JColorChooser.showDialog(null, "Choose color: ", Color.YELLOW);
                    if (bgC != null)
                        startBlink(500, 7, getContentPane().getBackground(), bgC, c -> getContentPane().setBackground(c)); //Change the number arguments at will.
                }
            });

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(new GridBagLayout()); //Just to keep the button centered.
            getContentPane().add(button);
            getContentPane().setBackground(Color.WHITE);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    public static void main(final String[] args) {
        new YourJFrame("Blinker frame").setSize(250, 250);
    }
}