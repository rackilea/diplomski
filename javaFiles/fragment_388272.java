buttonPanel = new JPanel(new GridBagLayout());
button = new JButton("Display Color");
button.addActionListener(new ButtonListener()); // Add event handler
button.setFont(font);


GridBagConstraints gc=new GridBagConstraints();
gc.fill=GridBagConstraints.HORIZONTAL;
gc.gridx=0;
gc.gridy=0;
            
buttonPanel.add(button,gc);