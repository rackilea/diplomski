JTextField textFieldA;
    JTextField textFieldB;
    boolean updating = false;

    textFieldA.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {  
            if(!updating) {
            updating = true;
            Document doc = (Document)e.getDocument();
            String line = doc.getText(0, doc.getLength());  
            textFieldB.setText(line);
            updating = false;
            }
        }
    textFieldB.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {  
            if(!updating) {
            updating = true;
            Document doc = (Document)e.getDocument();
            String line = doc.getText(0, doc.getLength());  
            textFieldA.setText(line);
            updating = false;
            }
        }