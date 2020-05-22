import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TimerVisible extends JFrame implements WindowFocusListener{
    private static final int TIMER_DELAY = 1000;
    static TimerVisible frame = new TimerVisible("chrono",2,1,3);//I set a random time
    JTextArea display;
    private Counter counter;
    Timer timer = null;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane();
        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane() {
        display = new JTextArea();
        display.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowFocusListener(this);
    }

    public TimerVisible(String name, int hours, int minutes, int secondes) {
        super(name);
        counter=new Counter(hours, minutes, secondes); //Counter is in secondes but is created with hours, minutes and seconds
    }


    public void windowGainedFocus(WindowEvent e) {
        displayMessage("WindowFocusListener method called: windowGainFocus.");
        if (timer != null && timer.isRunning()) {
            return;
        }

        timer = new Timer(TIMER_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter.getCounter() <= 0) {
                    timer.stop();
                } else {
                    displayMessage(counter.toString());
                    counter.decrement();
                }

            }
        });
        timer.start();
    }

    public void windowLostFocus(WindowEvent e) {
        displayMessage("WindowFocusListener method called: windowLostFocus.");
    }

    private void displayMessage(String msg) {
        display.append(msg+"\n");
        System.out.println(msg);
    }
}