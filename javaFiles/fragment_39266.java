JTextField randomNumberTextField= new JTextField(30);
//Code for randum number below.
gbc.gridx = 3;
gbc.gridy = 1;
randomNumberTextField.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {                      

           // Code to execute when you hit enter


    }}); 

//Code for function goes here.  
Random rn = new Random();
randomNumberTextField.setText(Integer.toString(rn.nextInt(51)));
p2.add(randomNumberTextField, gbc); //Adding to the panel, after done with all functions.