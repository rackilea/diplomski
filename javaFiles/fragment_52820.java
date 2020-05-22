public class TestTextPaneWrap {

    public static void main(String[] args) {
        new TestTextPaneWrap();
    }

    public TestTextPaneWrap() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            JTextPane editor = new JTextPane();
            editor.setMinimumSize(new Dimension(0, 0));
            add(new JScrollPane(editor));
        }

    }
}