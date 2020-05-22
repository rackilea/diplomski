@SuppressWarnings("serial")
class MyClockPanel extends JPanel {
    private static final Color FG = new Color(250, 250, 250);
    private static final Color BG = new Color(0, 110, 220);
    private static final int TIMER_DELAY = 200;
    private static final Font FONT = new Font("Monospaced", Font.PLAIN, 16);
    private JLabel clockLabel = new JLabel("", SwingConstants.CENTER);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy kk:mm:ss");

    public MyClockPanel() {
        setBackground(BG);
        clockLabel.setForeground(FG);
        clockLabel.setFont(FONT);
        displayDateTime();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        add(clockLabel);
        new javax.swing.Timer(TIMER_DELAY, e -> {
            displayDateTime();
        }).start();
    }

    private void displayDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        String text = dateTime.format(formatter);
        clockLabel.setText(text);
    }
}