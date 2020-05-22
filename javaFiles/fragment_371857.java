public void actionPerformed(ActionEvent ae) {
    for (int i = 0; i < names.length; i++) {
        for (int j = 0; j < names[i].length; j++) {
            if (ae.getSource() == buttons[i][j]) {
                if (ae.getSource() != buttons[0][3]
                                && ae.getSource() != buttons[0][4]) {
                    entryTA.append(names[i][j]);
                }
            }
        }
    }

    if (ae.getSource() == buttons[0][3]) {
        try {
            Document doc = entryTA.getDocument();
            if (doc.getLength() > 0) {
                doc.remove(doc.getLength() - 1, 1);
            }
        } catch (BadLocationException ble) {
            ble.printStackTrace();
        }
    } else if (ae.getSource() == buttons[0][4]) {
        entryTA.setText("");
    }

}