class CheckBoxListener implements ChangeListener {
        public void stateChanged(ChangeEvent ce) {

            int fontStyle = Font.PLAIN;

            if(boldCheckBox.isSelected())
                fontStyle |= Font.BOLD;

            if(italicCheckBox.isSelected())
                fontStyle |= Font.ITALIC;

            inputTextArea.setFont(inputTextArea.getFont().deriveFont(fontStyle));
        }           
    }
}