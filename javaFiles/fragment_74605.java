JComboBox<String> box = new JComboBox<>();
    box.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                // do something
            }
        }
    });