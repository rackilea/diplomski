DefaultComboBoxModel<Float> model = new DefaultComboBoxModel<Float>();
    model.addElement(1f);
    model.addElement(5f);
    model.addElement(10f);
    final JComboBox<Float> comboBox = new JComboBox<Float>(model);
    comboBox.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent arg0) {
            Float selectedItem = (Float) comboBox.getSelectedItem();
            if(selectedItem != null){
                drawPad.strokeSize = selectedItem;
            }

        }
    });