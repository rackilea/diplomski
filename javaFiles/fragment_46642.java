searchButton.addActionListener(new ActionListener() {  
       @Override  
        public void actionPerformed(ActionEvent ae) {
            String usrInput = input.getText();
            for (InventoryItem s : inventory) {
                if (usrInput.equalsIgnoreCase(s.getItemName())) {
                    //you can call output string here
                    outputText.append(" somehow put whatever the index is equal to here");

                }
            }

        }
    });