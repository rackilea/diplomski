...
myCheckBox.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // the checkbox was just selected
        } else {
            // the checkbox was just deselected
        }
    }
});