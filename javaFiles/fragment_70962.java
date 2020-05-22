list.addListSelectionListener(new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {

        Object item = list.getSelectedItem();
        if (item != null && item instance of LineOfText) {
            ListOfText lot = (LineOfText)lot;
            // Now we have access to the text value
            // Simply use "setText" on the text area to apply it

            textArea.setText(lot.getValue());

            // Remember, "textArea" should be replaced with the name
            // of your text area
        }

    }

});