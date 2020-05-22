class PlayerPanel extends JPanel {
    private Player player;
    private JSlider healthSlider = new JSlider(Player.HEALTH_MIN, Player.HEALTH_MAX, 0); 

    public PlayerPanel(Player player) {
        this.player = player;

        healthSlider.setValue(player.getHealth());
        healthSlider.setMajorTickSpacing(20);
        healthSlider.setMinorTickSpacing(5);
        healthSlider.setPaintTicks(true);
        healthSlider.setPaintLabels(true);

        // call method to change the player's health when the slider changes
        healthSlider.addChangeListener(clEvent -> healthChange());

        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Player Name:"));
        namePanel.add(Box.createHorizontalStrut(5));
        namePanel.add(new JLabel(player.getName()));

        setLayout(new BorderLayout());
        add(namePanel, BorderLayout.PAGE_START);
        add(healthSlider);
    }

    // ........ other methods


    private void healthChange() {
        player.setHealth(healthSlider.getValue());
    }

    // .......... other methods
}