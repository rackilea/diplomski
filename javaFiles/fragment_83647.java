public static void main(String[] args) {
    JTextArea area = new JTextArea();
    final StringBuilder builder = new StringBuilder();
    area.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void removeUpdate(DocumentEvent e) {
            builder.delete(e.getOffset(), e.getOffset() + e.getLength());
            System.out.println("Removed " + e.getLength() + " chars from SB");
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
                builder.insert(e.getOffset(), 
                        e.getDocument().getText(e.getOffset(), e.getLength()));
                System.out.println("Inserted " + e.getLength() + " chars into SB.");
            } catch ( BadLocationException ble ) {
                ble.printStackTrace();
            }
        }

        @Override public void changedUpdate(DocumentEvent e) { /* no-op */ }
    });

    final JFrame frame = new JFrame("DocumentListener Test");
    frame.add(area);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Final SB contents:");
            System.out.println(builder.toString());
        }
    });
    frame.pack(); frame.setVisible(true);
}