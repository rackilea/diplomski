package answer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RandomPanel extends JPanel implements ActionListener {
    private static final int TWO_SECONDS=2000;
    private static final int MAX=99999;
    private static final int MIN=0;
    private Timer timer = new javax.swing.Timer(TWO_SECONDS, this);

    private JLabel msgLabel;
    Random generator = new Random();
    public RandomPanel(Font f){
        msgLabel = new JLabel();
        msgLabel.setFont(f);
        msgLabel.setText(rand());
        add(msgLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            msgLabel.setText(msgLabel.getText().equals("")?rand():"");
    }

    private String rand() {
        //generate random beteween MIN & MAX
        return Integer.toString((int) (MIN + Math.random() * ( MAX - MIN) + 0.5));
    }
    public void start(){
        timer.start();
    }

    /**
     * Rudimentary test
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RandomPanel randomPanel = new RandomPanel(new Font("Serif", Font.BOLD, 50));
        frame.getContentPane().add(randomPanel);
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        randomPanel.start();
    }
}