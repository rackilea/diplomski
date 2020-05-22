private class Adder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (listOfTextFields.size() == 9) {
                // Give it a max of 9 text fields that can be created.
                return;
            }

            JTextField textfield = new JTextField();

            listOfTextFields.add(textfield);
            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
            textFieldConstraints.weightx = 0.5;
            textFieldConstraints.gridx = 0;
            textFieldConstraints.gridwidth = 2;
            textFieldConstraints.gridy = 3 + listOfTextFields.size();

            add(textfield, textFieldConstraints);

            revalidate();
            repaint();

        }

    }