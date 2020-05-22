public class Capture
{
    JPanel capture;
    JPanel panelCapture;
    JTextField scaleField;
    JButton changeScale;

    static final int PARENT_WIDTH = 800;
    static final int PARENT_HEIGHT = 600;

    static final int CHILD_WIDTH = 100;
    static final int CHILD_HEIGHT = 100;

    public static void main(String [] args)
    {
        Capture c = new Capture();
        c.doStuff();
    }

    public void doStuff()
    {
        capture = new JPanel();
        capture.setLayout(null);
        capture.setPreferredSize(new Dimension(PARENT_WIDTH, PARENT_HEIGHT));

        scaleField = new JTextField();
        scaleField.setBounds(100, 550, 200, 25);
        capture.add(scaleField);

        changeScale = new JButton("Scale");
        changeScale.setBounds(325, 550, 100, 25);
        changeScale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panelCapture.setBounds(getBounds(CHILD_WIDTH * Float.parseFloat(scaleField.getText()), CHILD_HEIGHT * Float.parseFloat(scaleField.getText())));
            }
        });
        capture.add(changeScale);

        panelCapture = new JPanel();
        panelCapture.setBackground(Color.blue);
        panelCapture.setBounds(getBounds(CHILD_WIDTH, CHILD_HEIGHT));
        capture.add(panelCapture);

        JFrame frame = new JFrame();
        frame.setContentPane(capture);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private Rectangle getBounds(float width, float height)
    {
        int left = (int) (PARENT_WIDTH - width) / 2;
        int top = (int) (PARENT_HEIGHT - height) / 2;
        return new Rectangle(left, top, (int) width, (int) height);
    }
}