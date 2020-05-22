comboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            JComboBox comboBox = (JComboBox) event.getSource();

            Object selected = comboBox.getSelectedItem();
            if(selected.toString().equals("item1"))
            field.setText("AA");
            else if(selected.toString().equals("item2"))
                field.setText("BB");

        }
    });
    getContentPane().add(comboBox);
    getContentPane().add(field);
}