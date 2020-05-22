public class TestLayout18 {

    public static void main(String[] args) {
        new TestLayout18();
    }

    public TestLayout18() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                JEditorPane editorPane = new JEditorPane();
                try {
                    editorPane.setPage(new URL("http://docs.oracle.com/javase/6/docs/api/javax/swing/JScrollPane.html"));
                } catch (IOException e) {
                    System.err.println("Attempted to read a bad URL");
                }
                editorPane.setEditable(false);
                JScrollPane editorScrollPane = new JScrollPane(editorPane);
                frame.add(editorScrollPane);

                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}