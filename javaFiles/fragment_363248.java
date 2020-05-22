private JButton aButton = new JButton("I am a Button \n");
private JLabel label = new JLabel("Label \n");
private JTextArea ta = new JTextArea("Text area", 5, 5);
private JTextField jj = new JTextField(5);

public SwingIt() {
    setUndecorated(true);
    setBackground(new Color(0, 0, 0, 0));
    setSize(new Dimension(600, 500));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("bbb");
            if (g instanceof Graphics2D) {
                final int R = 250;
                final int G = 210;
                final int B = 220;
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                        0.0f, getHeight(), new Color(R, G, B, 255), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    };
    setContentPane(panel);
    setLayout(new GridBagLayout());
    add(aButton);
    add(label);
    add(ta);
    add(jj);
    pack();
}