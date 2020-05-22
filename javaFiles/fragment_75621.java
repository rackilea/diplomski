// don't use null as the first parameter if the GUI is already showing
String nameEnt = JOptionPane.showInputDialog(null, "First Name: ");
if (nameEnt == null) {
    // user canceled. get out of here. 
    System.exit(0);
}