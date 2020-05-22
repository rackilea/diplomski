import javax.swing.JLabel;

public class Worker implements Runnable{
    private int i;
    private JLabel label;
    public Worker(int i, JLabel label) {
        this.i = i;
        this.label = label;
    }

    public void run() {
        label.setText("You have " + i + " seconds.");
    }
}