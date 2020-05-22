checkBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            boolean flag = e.getStateChange() == ItemEvent.SELECTED;
            jFormattedTextField1.setEnabled(!flag);// Here if check box is selected then flag value will be true and this text field would be disabled
            jFormattedTextField2.setEnabled(!flag);
            jFormattedTextField3.setEnabled(flag);
        }
    });