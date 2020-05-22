public class Test {
    public static void main(String[] args) throws BadLocationException {
        JFrame frame = new JFrame("Test");

        JTabbedPane tabs = new JTabbedPane();

        JTextPane textPane = new JTextPane();
        textPane.getDocument().insertString(0, "Hello World!", null);
        tabs.addTab("Test", new JScrollPane(textPane));

        frame.add(tabs);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

}