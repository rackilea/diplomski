public class SecondGui extends JFrame {

    private int c = 0;
    private JFrame frame;
    private JButton button;

    public SecondGui(int i) {

        this.c = i;
        initialize();
    }

    void initialize() {

        frame = new JFrame("Test");
        setSize(1024,700);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLocation(50*i, 50*i);

        // Set layout manager
        setLayout(new BorderLayout());

        button = new JButton("B");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("C: " + c);

            }

        });

        add(button);
     }

}