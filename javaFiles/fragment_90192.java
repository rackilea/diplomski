comboBox.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            String name = comboBox.getSelectedItem().toString();
            for (int i = 0; i < c.getEtairies().size(); i++) {
                if (c.getEtairies().get(i).getName().equals(name)) {
                    for (int j = 0; j < c.getEtairies().get(i).getErgazomenoi().size(); j++) {

                        comboBox_1.addItem(c.getEtairies().get(i).getErgazomenoi().get(j).getSurname());

                    }
                }
            }
        }
    });