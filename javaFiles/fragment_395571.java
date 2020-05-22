public class Texting extends JFrame {

    Texting() {

        List<String> list = new ArrayList<>();
        list.add("AAAAAAA");
        list.add(" ");
        list.add("BBBB");

        JTextPane pane = new JTextPane();
        Document doc = pane.getDocument();
        for (String s : list)
            try {
                doc.insertString(doc.getLength(), s, null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }

        add(pane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {

        new Texting();
    }
}