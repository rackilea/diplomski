JPanel playerPanel = new JPanel();
List<JTextField> playerNames = new ArrayList<JTextField>();

public OptionPlayerNames() {
    for (int i = 0; i < 8; i++) {
        JTextField playerName = new JTextField();

        playerPanel.add(new JLabel("Player " + (i + 1)));
        playerPanel.add(playerName);

        playerNames.add(playerName);
    }
    playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
    playerPanel.add(Box.createHorizontalStrut(5));
}

public JPanel getPanel() {
    return playerPanel;
}

public String getPlayerNames() {
    String output = "";
    // Compound you exit from the playerNames List
    // Or better, return a List of String
    return output;
}