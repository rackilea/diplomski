public class MouseListenerExample extends JFrame {

    public static class MyMouseListener extends MouseAdapter {
        private static final Collection<JLabel> labels = new ArrayList<JLabel>();
        private final JFrame frame;

        public MyMouseListener(JFrame frame, JLabel label) {
            this.frame = frame;
            labels.add(label);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (JLabel label : labels) {
                String text = label.getText();
                if (text.startsWith("X ")) {
                    label.setText(text.substring(2));
                }
            }
            JLabel currentLabel = (JLabel) e.getComponent();
            currentLabel.setText("X " + currentLabel.getText());
        }

    }

    public MouseListenerExample() {
        super("MouseListener Example");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        for (int i = 0; i < 10; i++) {
            JLabel jLabel = new JLabel("Label " + i);
            c.add(jLabel);
            jLabel.addMouseListener(new MyMouseListener(this, jLabel));
        }
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseListenerExample();
    }
}