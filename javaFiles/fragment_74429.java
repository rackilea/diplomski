public class Problematic {

    public static void main(String[] args) {
        JFrame f = new JFrame("frame");
        f.getContentPane().setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        JButton button = new JButton("Whatever here");
        p1.add(button);

        JPanel p = new JPanel(new GridLayout(1, 1)); //assign gridlayout so text area fills panel
        JTextArea t2 = new JTextArea(5, 30);
        t2.setText("this is some random text\nthat may go for many rows\nso it may look messy");

        JScrollPane scrollPane = new JScrollPane(t2);       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(scrollPane);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p,p1);
        f.getContentPane().add(splitPane, BorderLayout.CENTER);

        f.setSize(600, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}