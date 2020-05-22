// Instantiate components and configure their corresponding GridBagConstraints attributes
    // refPlusType properties
    refPlusType = new JLabel("<html><h3>"+"Reference"+" - "+"Job Type"+" </h3><hr /></html>");
    refPlusTypeGC = new GridBagConstraints();
    refPlusTypeGC.gridx = 0; // Grid position 
    refPlusTypeGC.gridy = 0;
    refPlusTypeGC.gridwidth = 2; // Number of colums occupied by component
    refPlusTypeGC.insets = new Insets(5, 10, 5, 10); // Specifies margin

    // addressLine1 properties
    addressLine1 = new JTextField();
    addressLine1GC = new GridBagConstraints();
    addressLine1GC.gridx = 0; 
    addressLine1GC.gridy = 1;
    addressLine1GC.gridwidth = 2; 
    addressLine1GC.insets = new Insets(0, 10, 0, 10); 
    addressLine1GC.fill = GridBagConstraints.HORIZONTAL; // Specifies component fill Horizontal space

    // addressLine2 properties
    addressLine2 = new JTextField();
    addressLine2GC = new GridBagConstraints();
    addressLine2GC.gridx = 0; 
    addressLine2GC.gridy = 2;
    addressLine2GC.gridwidth = 2; 
    addressLine2GC.insets = new Insets(0, 10, 0, 10); 
    addressLine2GC.fill = GridBagConstraints.HORIZONTAL; // Specifies component fill Horizontal space 
    addressLine2GC.weighty = 1; // Required for anchor to work.
    addressLine2GC.anchor = GridBagConstraints.NORTH; // Position in container

    // Add components to this HALLogisticsDetailsPanel
    this.add(refPlusType, refPlusTypeGC);
    this.add(addressLine1, addressLine1GC);
    this.add(addressLine2, addressLine2GC);