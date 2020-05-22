public class OvalDrawer extends JApplet {

    private JLabel numberL;
    private JTextField numberTF;
    private NumHandler numHandler;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public int number;

    //Create Layout
    public void init() {
//        setLayout(new MigLayout("wrap 2"));
        setLayout(new BorderLayout());
        numberL = new JLabel("Enter number of ovals to draw:");
        numberTF = new JTextField(7);

        JPanel header = new JPanel();
        header.add(numberL);
        header.add(numberTF);

        add(header, BorderLayout.NORTH);
        add(new PaintPane());

        numHandler = new NumHandler();
        numberTF.addActionListener(numHandler);

//        JPanel drawArea = new JPanel();
//        drawArea.setSize(400, 400);
//        drawArea.setBorder(BorderFactory.createTitledBorder("Draw Area"));
//        add(drawArea, "span 2");

        setSize(WIDTH, HEIGHT);
    }

    //Event Handler
    public class NumHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            number = Integer.parseInt(numberTF.getText());
            repaint();
        }
    }

    //Draw Ovals
    public class PaintPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 10;
            int y = 10;
            int width = 200;
            int height = 100;

            for (int i = 0; i < number; i++) {
                g.drawOval(x, y, width, height);

                x += 5;
                y += 5;
                width += 5;
                height += 5;
            }
        }
    }
}