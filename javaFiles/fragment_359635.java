jTextField1.getDocument().addDocumentListener(new DocumentListener() {

    public void keyTyped(java.awt.event.KeyEvent evt) {

        void insertUpdate(DocumentEvent e) {
            // ... code to check document change here
        }

        void removeUpdate(DocumentEvent e){
            // ... code to check document change here
        }

        void changedUpdate(DocumentEvent e){
            // ... code to check document change here
        }

    }

});