public void actionPerformed(ActionEvent textBox) { 
    String text = textField.getText();
    String command = text.substring(0, text.indexOf(" "));
    String args = text.substring(text.indexOf(" ") + 1);
    switch (command) {
        case "chat":
            // Pass everything but the command
            player.chat(args);
            break;
        case "/attack":
            player.attack(args);
            break;
        default:
            // Handle bad user input
    }
}