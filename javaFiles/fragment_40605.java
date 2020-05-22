@SuppressWarnings("serial")
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
        healthSlider.addChangeListener(clEvent -> healthChange());

        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Player Name:"));
        namePanel.add(Box.createHorizontalStrut(5));
        namePanel.add(new JLabel(player.getName()));

        setLayout(new BorderLayout());
        add(namePanel, BorderLayout.PAGE_START);
        add(healthSlider);
    }

    // make JPanel wider
    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        int w = 2 * superSize.width;
        int h = superSize.height;
        return new Dimension(w, h);
    }


    private void healthChange() {
        player.setHealth(healthSlider.getValue());
    }

    public Player getPlayer() {
        return player;
    }
}