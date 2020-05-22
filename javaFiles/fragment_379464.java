JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
GridBagConstraints constraints = new GridBagConstraints(
    0, RELATIVE,    // x = 0, y = below previous element
    1, 1,           // cell width = 1, cell height = 1
    0.0, 0.0        // how to distribute space: weightx = 0.0, weighty = 0,0 
    GridBagConstraints.CENTER,  // anchor
    GridBagConstraints.BOTH,    // fill
    new Insets(0, 0, 0, 0),     // cell insets
    0, 0);          // internal padding
...
    panel.add(button[i], constraints);