public class ClientClass {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientClass window = new ClientClass();
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
    public ClientClass() {
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
//  Logic Logical;
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 590, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpriteField panel = new SpriteField();

        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.GRAY);
        frame.getContentPane().add(panel);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.start();
            }
        });
        frame.getContentPane().add(btnStart, BorderLayout.SOUTH);
    }
}