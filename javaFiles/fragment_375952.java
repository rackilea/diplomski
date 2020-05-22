int a = 0;  // variable
private JFrame frame;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                asd window = new asd();
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
public asd() {
    super();
    Timer time=new Timer(1000, this); 
    time.start(); 
    initialize();
}

/**
 * Initialize the contents of the frame.
 */

private JLabel label;
private void initialize() {

    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JPanel panel = new JPanel();
    panel.setBounds(20, 11, 137, 111);
    frame.getContentPane().add(panel);
    panel.setLayout(null);

    label = new JLabel();
    label.setBounds(0, 25, 127, 58);
    label.setText("" + a);
    panel.add(label);

    System.out.println(a); //it is counting on console but in Jlabel variable is not.

}

@Override
public void actionPerformed(ActionEvent arg0) {
    a++;

    label.setText("" + a);

}