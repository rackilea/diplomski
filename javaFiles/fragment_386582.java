private void startGame(String message) {
    String host, login;
    int temp = 0;

    JTextField hostText = new JTextField();
    JTextField loginText = new JTextField();

    Object[] info = {"Host: ", hostText, "login ID: ", loginText};

    temp = JOptionPane.showConfirmDialog(rootPane, info, message, JOptionPane.OK_CANCEL_OPTION);

    while (true) {
        try {
            if (temp == JOptionPane.OK_OPTION) {
                host = hostText.getText();
                login = loginText.getText();

                game = new Client(login, host, 5555, this); //Initializes the game
                initComponents();
                break;
            } else if (temp == JOptionPane.CANCEL_OPTION || temp == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        } catch (IOException e2) {
            connectionError("Can't connect to the game server!");
            System.exit(0);
        }
    }
    //Scrubs memory for more RAM :)
    login = null;
    host = null;

}