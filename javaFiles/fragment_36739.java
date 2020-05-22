String message = "Enter Your Name:";
    String playerName = null;
    do {
        playerName =
            JOptionPane.showInputDialog(message);
        message = "<html><b style='color:red'>Enter Your Name:</b><br>"
                + "Use letters only.";          
    } while(playerName != null && !playerName.matches("[a-zA-Z]+"));

    System.out.println("PlayerName: " + playerName);