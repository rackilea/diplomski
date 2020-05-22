JPanel left_panel = new LayerContainer();
    panel_1.setBounds(28, 47, 129, 97);
    add(panel_1);

    LayerContainer right_panel = new LayerContainer();
    layerContainer.setBounds(203, 47, 129, 97);
    add(layerContainer);

    JLabel lblToDrag = new LayerItem("Drag Me");
    GridBagConstraints gbc_lblToDrag = new GridBagConstraints();
    gbc_lblDragMe.gridx = 0;
    gbc_lblDragMe.gridy = 0;
    panel_right.add(lblToDrag, gbc_lblToDrag);