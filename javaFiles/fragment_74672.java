public class UI extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //Run in EDT
            UI myProgram = new UI();
            myProgram.setVisible(true);
        });
    }

    public UI() {
        super("title");//call super for frame
        this.setSize(new Dimension(500, 300));
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        UserPanel p = new UserPanel(this);

        //Use border layout to make p fit the whole frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.CENTER);
    }

    public class UserPanel extends JPanel implements ActionListener {

        private Timer time = new Timer(1, this);
        private UI myFrame;

        public UserPanel(UI myFrame) {
            this.myFrame = myFrame;
            this.setSize(myFrame.getSize());

            time.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("painting");
            g.setColor(Color.BLACK);
            g.fillRect(this.getWidth() / 2, this.getHeight() / 2, 50, 50);
        }
    }
}