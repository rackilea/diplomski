import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TimerTest extends Frame implements ActionListener {
    Timer to;

    TimerTest() {
    to = new Timer(true);

        System.out.println("Now=" + System.currentTimeMillis());
        to.schedule(new TimeOutTask("Short#1 - 250"), 250);
        to.schedule(new TimeOutTask("Long - 10050"), 10050);
        to.schedule(new TimeOutTask("Short#2 - 250"), 250);
        to.schedule(new TimeOutTask("Medium - 5050"), 5050);
        to.schedule(new TimeOutTask("Short#3 - 250"), 250);

        Button b = new Button("Click to exit");
        b.addActionListener(this);
        this.add(b);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TimerTest t = new TimerTest();
    }

    public void actionPerformed(ActionEvent a) {
        this.dispose();
    }
}

class TimeOutTask extends TimerTask {
    String s;

        TimeOutTask(String s) {
        this.s = s;
    }

    public void run() {
        System.out.println(s);
    }
}