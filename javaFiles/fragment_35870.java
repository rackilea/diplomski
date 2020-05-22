comboBox.addItemListener(new ItemListener() {

    @Override
    public void itemStateChanged(ItemEvent e) {
        String s = comboBox.getSelectedItem().toString();
        //passToAnotherClassMethod(s);
    }
});