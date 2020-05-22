public change_username() {
        super("Change Username"); 
        setPreferredSize (new Dimension (400, 85));
        setLayout (null);

        statusBar = new JLabel("Enter your username");
        add(statusBar, BorderLayout.SOUTH);
        statusBar.setBounds(20, 130, 250, 30); 

        uT1 = new JLabel("Username");
        username_input = new JTextField(10);

        pwT = new JLabel("Password");
        password_input = new JPasswordField(10); 

        uCh = new JLabel("New Username");
        username_change = new JTextField(10);

        uT1.setBounds(10, 10, 150, 30); 
        username_input.setBounds(100, 10, 100, 30); 
        pwT.setBounds(10, 50, 150, 30); 
        password_input.setBounds(100, 50, 100, 30);        
        uCh.setBounds(10, 90, 150, 30); 
        username_change.setBounds(100, 90, 100, 30); 

        add(uT1);
        add(username_input);

        // SET THE TEXT HERE Before the Listener **************************

        username_input.setText(getUserName());

        // *****************************************************************