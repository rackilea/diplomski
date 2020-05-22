JButton newCustomerButton = new JButton("Add Customer");
    newCustomerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newCustomer newCustomerFrame = new newCustomer();
            newCustomerFrame.setVisible(true);

        }
    });