public Player() {
    //setBackground(Color.green);
    setSize(600, 400);
    name = new JLabel();//Input hint
    JOptionPane nameOption = new JOptionPane();
    String nameEnt = nameOption.showInputDialog("First Name: ");
    if (nameEnt == null) {
        // user canceled. get out of here. 
        System.exit(0);

        // or return;  
        // or throw some exception
    }
    if (!nameEnt.matches("[a-zA-Z]+")) {
        name.setText(nameEnt);
    }
    if (nameEnt.length() == 0) {
        //if this condition is true JOption stays until name is entered or canceled 
    }
    // if (nameEnt == nameOption.CANCEL_OPTION) {
       //  System.exit(0);
    // }
}