private class TheHandler implements ItemListener{
    public void itemStateChanged(ItemEvent event) {

        if(event.getStateChange() == ItemEvent.SELECTED) {
            Object source = event.getSource();
            if (source instanceof JComboBox) {
                JComboBox cb = (JComboBox)source;
                Object selectedItem = cb.getSelectedItem();
                if ("The Matrix".equals(selectedItem)) {
                    // Do the matrix
                } else if ("Another Option".equals(selectedItem)) {
                    // Do another option
                }
            }
        }   
    }
}