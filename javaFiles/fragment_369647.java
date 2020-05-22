GridBagLayout grid = new GridBagLayout();  
GridBagConstraints gbc = new GridBagConstraints();  
setLayout(grid); 
//add TF
gbc.gridx=1;
gbc.gridy=0;
this.add(new JTextField(10),gbc);
gbc.gridx=0;
gbc.gridy=1;
this.add(new JButton("+"),gbc);
gbc.gridx=1;
this.add(new JButton("-"),gbc);
gbc.gridx=2;
this.add(new JButton("Reset"),gbc);

//also for another display (first TF will be on the same x as - Button) 
//(and maybe you want TF to cover the space for all 3 Button +,-,Reset)
//you could add 2 panels one over other (x=0 : y=0,y=1), place TF on P1 and all Buttons on P2