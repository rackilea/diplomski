import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class mainPanel implements ActionListener {

    JFrame frame1;
    JPanel panel1;
    JButton button = new JButton("START");

    boolean buttonPressed = false;
    boolean move = false;
    Timer timer;
    int direction = 1;
    int x = 0;

    public static void main(String[] args) {
        new mainPanel().loadGUI();

    }

    public void loadGUI() {
        frame1 = new JFrame("Moving button");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setSize(300, 58);
        frame1.setResizable(false);

        panel1 = new JPanel(); // Xwidth=294, Yheight=272
        panel1.setSize(300, 30);
        panel1.setLayout(null);
        frame1.add(panel1);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setLocation(dim.width / 2 - frame1.getSize().width / 2, dim.height / 2 - frame1.getSize().height / 2);

        button.setSize(80, 30); //X, Y
        panel1.add(button);
        button.addActionListener(this);

        moveButton();

    }

    public void moveButton() {
        if (timer == null) {
            initTimer();
        }
        move = !move;
        if (move) {
            button.setText("STOP");
            direction = (direction == 0) ? 1 : 0;
            timer.start();
        } else {
            button.setText("MOVE");
            timer.stop();
        }
    }

    public void initTimer() {
        timer = new Timer(10, (e) -> {
            switch (direction) {
                case 0: // right
                    x++;
                    if (x >= panel1.getWidth() - button.getWidth()) {
                        direction = 1;
                    }
                    break;
                case 1: // left
                    x--;
                    if (x <= 0) {
                        direction = 0;
                    }
                    break;
            }
            button.setLocation(x, 0);
            panel1.repaint();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveButton();
    }
}