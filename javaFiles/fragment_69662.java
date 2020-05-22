import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameDev extends JFrame {

    public static void main(String[] arg) {

        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        GameDev b = new GameDev();
        b.getContentPane().setBackground(Color.yellow);
        b.run(dm);

    }

    public void run(DisplayMode dm) {
        setBackground(Color.YELLOW);
        setForeground(Color.red);
        setFont(new Font("Arial", Font.PLAIN, 25));

        final Screen s = new Screen();
        s.setFullScreen(dm, this);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.restoreScreen();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("You know you love me home boy.", 200, 200);

    }

    public class Screen {

        GraphicsDevice videoCard;

        public Screen() {

            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            videoCard = env.getDefaultScreenDevice(); // acces computer screen

        }

        public void setFullScreen(DisplayMode dm, JFrame window) {
            window.setUndecorated(true);
            window.setResizable(false);
            videoCard.setFullScreenWindow(window);

            if (dm != null && videoCard.isDisplayChangeSupported()) {

                try {

                    videoCard.setDisplayMode(dm);

                } catch (Exception ex) {

                }
            }
        }

        public Window getFullScreenWindow() {

            return videoCard.getFullScreenWindow(); //returns ur window

        }

        public void restoreScreen() {

            Window w = videoCard.getFullScreenWindow();

            if (w != null) {

                w.dispose();
            }
            videoCard.setFullScreenWindow(null); // takes away from full screen.
        }

    }

}