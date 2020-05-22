import javax.swing.*;
import java.awt.event.*;

class Example implements ActionListener {
    Timer timer;
    int count=0;
    JButton startButton;
    JButton stopButton;
    JLabel countLabel;
    JFrame frame;
    JPanel contentPane;

    public Example() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(this);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        countLabel = new JLabel("0");

        contentPane.add(startButton);
        contentPane.add(countLabel);
        contentPane.add(stopButton);

        ActionListener listener = new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                            count++;
                countLabel.setText(count+"");
                    }
                };
        timer = new Timer(100,listener);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);

    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            timer.start();
        }
        if(e.getSource() == stopButton) {
            timer.stop();
        }
    }
    public static void main(String args[]) {
        new Example();
    }
}