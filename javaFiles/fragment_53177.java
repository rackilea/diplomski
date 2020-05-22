import java.awt.EventQueue;

public class ClassB {

    private JFrame frame;
    private static int i = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClassB window = new ClassB();
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
    public ClassB() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        final ClassA a = new ClassA();

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnUpdate = new JButton("Update Value");
        btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                i = i + 10;
                a.updateProgressBar(i);
            }
        });
        btnUpdate.setBounds(10, 52, 109, 23);
        frame.getContentPane().add(btnUpdate);
    }
}