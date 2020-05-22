public void actionPerformed(ActionEvent e) {

    String value = e.getActionCommand();
    String message = "";

    switch(value){
        case "100":
            message = "RED";
            break;
        case "400":
            message = "BLUE";
            break;
        default:
            message = "Un recognized button pressed";
            break;
    }

    JOptionPane.showInputDialog(null,message);
}