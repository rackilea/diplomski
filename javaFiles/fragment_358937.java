login.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {

        // .... etc...

        JOptionPane.showMessageDialog(null, "Welcome");
        frame.dispose();

        MainScreen s = new MainScreen();
        // !!  s.setVisible(true);  // don't call this!
     }