GridBagConstraints gbc = new GridBagConstraints();
gbc.weightx = 1.0;
gbc.weighty = 1.0;
gbc.fill = GridBagConstraints.NONE;
gbc.anchor = GridBagConstraints.NORTHEAST;
panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,
            (int) tabBounds.getHeight()));
glassPane.add(panel, gbc);