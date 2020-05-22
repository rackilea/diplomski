public class Clock extends JFrame {
    public static int seconds = 0;
    public static int minutes = 0;
    public static int hours = 9;

    public static ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // insert code here
        }
    };

    public static Timer timer = new Timer(1000, taskPerformer);

    public Clock() {
        super("Clock");
        timer.addActionListener(taskPerformer);    
    }
}