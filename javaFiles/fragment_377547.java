public void actionPerformed(ActionEvent e){

        JButton src = (JButton) e.getSource()    //get the objectthat triggered the event
        if (src.equals(logIn))        //if the source is the LOG IN button (in our case it is the only thing that can trigger an event)
            logOut.setVisible(true);    ///finally! make the LOG OUT visible!
    }