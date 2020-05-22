class Client implements ActionListener {
    private static Client instance = new Client();
    public static Client getInstance() { return instance; }

    public void actionPerformed(ActionEvent e) {
        // do the thing you want to do here.
    }
}