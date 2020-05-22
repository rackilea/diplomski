public class Sample extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sample frame = new Sample();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Sample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane
                .setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.add(textPane);
        scrollPane.setViewportView(textPane);
        panel.add(scrollPane, BorderLayout.CENTER);

        final StyledDocument doc = textPane.getStyledDocument();
        insertStringToDoc(getString() + "\n", doc, doc.getLength());

    }

    private void insertStringToDoc(String str, StyledDocument doc, int offset) {
        try {

            SimpleAttributeSet keyWord = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWord, Color.RED);
            StyleConstants.setBackground(keyWord, Color.YELLOW);
            StyleConstants.setBold(keyWord, true);
            doc.insertString(doc.getLength(), str, keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getString() {
        return "hello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello "
                + "\nhello hello hello hello hello hello hello hello hello hello hello ";
    }
}