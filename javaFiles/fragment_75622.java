public Player() {
    setSize(600, 400);  // This is not good to do. Ask for details and I'll tell.

    name = new JLabel();// Don't forget to add this to the GUI!

    String nameEnt = "";
    while (nameEnt.trim().isEmpty()) {
        // if the GUI is already showing, pass a component from it as the first param here, not null
        nameEnt = JOptionPane.showInputDialog(null, "First Name: ");
        if (nameEnt == null) {
            // user canceled. get out of here. 
            System.exit(0);

            // or return;  
            // or throw some exception
        } else if (!nameEnt.matches("[a-zA-Z]+")) {
            name.setText(nameEnt);
        } else {
            // set it to "" so that we keep looping
            nameEnt = "";
        }
    }
}