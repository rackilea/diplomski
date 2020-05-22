import java.awt.EventQueue;

public class ClassA {

    private JFrame frame;
    private JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClassA window = new ClassA();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ClassA() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 89, 291, 34);
        frame.getContentPane().add(progressBar);
        frame.setVisible(true);
    }

    public void updateProgressBar(int value) {
        progressBar.setValue(value);
    }
}