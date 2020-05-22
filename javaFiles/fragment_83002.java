public class Clock extends JFrame implements ActionListener {
    public static int seconds = 0;
    public static int minutes = 0;
    public static int hours = 9;

    public void actionPerformed(ActionEvent e) {
        // code
    }

    public Timer timer;

    public Clock() {
        super("Clock");
        timer = new Timer(1000, this);
        timer.addActionListener(this);    
    }
}