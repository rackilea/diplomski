public class TestFrameSize extends JFrame {

    public TestFrameSize() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(250, 250));

        JLabel left = new JLabel("Left");
        JLabel right = new JLabel("Right");

        Dimension pSize = new Dimension(100, 100);
        Dimension mSize = new Dimension(25, 100);

        left.setPreferredSize(pSize);
        left.setMinimumSize(mSize);
        right.setPreferredSize(pSize);
        right.setMinimumSize(mSize);

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);

        JPanel content = new JPanel(new GridBagLayout());
        content.add(pane);

        setLayout(new BorderLayout());
        add(content);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new TestFrameSize().setVisible(true);

    }
}