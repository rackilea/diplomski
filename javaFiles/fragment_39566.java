JTextField tf;

public T() {
    tf = new JTextField();
    JFrame f = new JFrame();
    f.add(tf);
    f.pack();
    f.setVisible(true);

    PlainDocument d = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            String upStr = str.toUpperCase();
            if (getLength() == 0) {
                char c = upStr.charAt(0);
                if (c == 'A' || c == 'T' || c == 'J' || c == 'Q' || c == 'K' || (c >= '2' && c <= '9')) {
                    super.insertString(offs, upStr, a);
                }
            }

        }
    };
    tf.setDocument(d);

}