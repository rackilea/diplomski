@SuppressWarnings("serial")
class MyTimerPanel extends JPanel {
    private static final Color FG = new Color(0, 0, 238);
    private static final Font FONT = new Font("Times New Roman", 0, 14);
    private static final int TIMER_DELAY = 40;
    private static final String FORMAT_TXT = "Elapsed Time: %02d:%02d:%02d";
    private JLabel timerLabel = new JLabel("", SwingConstants.CENTER);
    private LocalDateTime startTime = null;
    private Timer timer = null;

    public MyTimerPanel() {
        timerLabel.setForeground(FG);
        timerLabel.setFont(FONT);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        timerLabel.setText(String.format(FORMAT_TXT, 0, 0, 0));
        add(timerLabel);
    }

    public void start() {
        stop();
        startTime = LocalDateTime.now();
        timer = new Timer(TIMER_DELAY, e -> incrementTime());
        timer.start();
    }

    public void stop() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    private void incrementTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(startTime, currentTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, currentTime) % 60;
        long seconds = ChronoUnit.SECONDS.between(startTime, currentTime) % 60;
        String text = String.format(FORMAT_TXT, hours, minutes, seconds);
        timerLabel.setText(text);
    }
}