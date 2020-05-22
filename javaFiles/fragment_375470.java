class Frame extends JFrame {
    private final int WIDTH = 640, HEIGHT = 480;
    private Panel p = new Panel();

    Frame() {
        super("Java Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // add the panel to the frame
        add(p);

        pack();
    }

}

class Panel extends JPanel {
    JButton b = new JButton("Button");

    Panel() {
        b.setBounds(0,  0, 200, 100);
        add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b.setText("Pressed");
            }
        });
    }


    // You can also get rid of this method, 
    // I just leave it here to show that I removed the b.paint(g) line
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}