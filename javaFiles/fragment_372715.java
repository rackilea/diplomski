public void setJPanel(JTextField array[], JPanel container, String s, boolean docListener) {
    for (int i = 0; i < 8; i++) {
        array[i] = new JTextField(s, 4);
        if (docListener) {
            array[i].getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent de) {
                    setCiphertext();
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    setCiphertext();
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    setCiphertext();
                }
            });
        }
        container.add(array[i]);
    }
}

[...]

    setJPanel(arrayIV, panel1, "1a", true);
    setJPanel(plaintextArray, panel2, "1b", true);
    setJPanel(ciphertextArray, panel3, "1", false);