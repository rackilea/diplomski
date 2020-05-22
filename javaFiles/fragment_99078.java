button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String ip = input.getText();
        output.setText(input.getText());
        // Initialize a ConnBean object, parameter list is ip, username, password
        if ( cb == null ) {
            cb = new ConnBean(ip , "username","password");
        } else {
            cb.setHost(ip);
        }

        // Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a singleton SSHExec instance
        ssh = SSHExec.getInstance(cb);          
        // Connect to server
        ssh.connect();
    }
});