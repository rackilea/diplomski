GUIExample(){
    frame = new JFrame("GUI Example in Swing");    //frame's head text
    logIn = new JButton("LOG IN");
    logOut = new JButton("LOG OUT");
    frame.setSize(300,400);
    frame.setVisible(true);
    frame.add(logIn);
    logIn.setVisible(true);
    frame.add(logOut);
    logOut.setVisible(false);        //The LOG OUT is invisible now!
    logIn.addActionListener(this);        //this tells the JVM to keep an eye on this
                                          // button and run the actionPerformed method
                                          // if it gets pushed!
}