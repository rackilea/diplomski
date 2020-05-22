/*
             * Center Panel
     */
  JPanel centerPanel = new JPanel();
  centerPanel.setBackground(Color.yellow);
  centerPanel.setSize(300,300);
  GridBagLayout layout = new GridBagLayout();

  centerPanel.setLayout(layout);        
  GridBagConstraints gbc = new GridBagConstraints();

  gbc.fill = GridBagConstraints.HORIZONTAL;
  gbc.gridx = 0;
  gbc.gridy = 0;
  labelName = new JLabel("Enter your name: ");
    //labelName.setBorder(new EmptyBorder(25,50,10,10));
  labelName.setFont(new Font("Serif", Font.PLAIN, 15));
  centerPanel.add(labelName,gbc);

  gbc.gridx = 1;
  gbc.gridy = 0;
  txtName = new JTextField(25);
  txtName.setHorizontalAlignment(JTextField.CENTER);
  txtName.setHorizontalAlignment(SwingConstants.LEFT);
  centerPanel.add(txtName,gbc); 

  gbc.fill = GridBagConstraints.HORIZONTAL;
  gbc.ipady = 20;   
  gbc.gridx = 0;
  gbc.gridy = 1;
  labelAddress = new JLabel("Enter you address: ");
  labelAddress.setFont(new Font("Serif", Font.PLAIN, 15));
  centerPanel.add(labelAddress,gbc); 

  gbc.gridx = 1;
  gbc.gridy = 1;  
  txtAddress = new JTextField(25);
  txtAddress.setHorizontalAlignment(JTextField.CENTER);
  txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
  centerPanel.add(txtAddress,gbc);  



  panel.add(centerPanel);