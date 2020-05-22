public class Sample extends JPanel {

    public Sample() {
        super(new BorderLayout());
        setBackground(Color.BLACK);

        TransparentButton testButton = new TransparentButton("hello");
        testButton.setSelected(true);

        add(testButton, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hello Word demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new Sample();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    class TransparentButton extends JRadioButton {
        public TransparentButton(String string) {
            super(string);
            setOpaque(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setForeground(Color.white);
            setBackground(Color.BLACK);
        }
    }

}