public static void main(String[] args)
{
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(400, 250));

    Container cp = frame.getContentPane();
    cp.setLayout(new MigLayout("fill, debug"));

    String wrap = "wrap,";
    String span2 = "spanx 2,";
    String span3 = "spanx 3,";

    cp.add(new JLabel("X1"));
    cp.add(new JLabel("Y1"), span2);
    cp.add(new JLabel("X5"));
    cp.add(new JLabel("Y5"), wrap);
    cp.add(new JLabel("X2"));
    cp.add(new JLabel("Y2"), span2);
    cp.add(new JLabel("X6"));
    cp.add(new JLabel("Y6"), wrap);
    cp.add(new JLabel("X3"));
    cp.add(new JLabel("Y3"), span2);
    cp.add(new JLabel("X7"));
    cp.add(new JLabel("Y7"), wrap);
    cp.add(new JLabel("Special 1"), span2);
    cp.add(new JLabel("Special 2 with long description"), span3 + wrap);
    cp.add(new JLabel("X4"));
    cp.add(new JLabel("Y4"), span2);
    cp.add(new JLabel("X7"));
    cp.add(new JLabel("Y8"));

    frame.pack();
    frame.setVisible(true);
}