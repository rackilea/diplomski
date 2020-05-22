public class FlashApplet extends JApplet {

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                setLayout(new BorderLayout());
                add(new FlashPane());

            }
        });
    }

    @Override
    public void start() {
    }

    public static class FlashPane extends JPanel {

        protected static final String[] MESSAGES = {"Bad Boys", "What you gonna do"};

        private Timer flashTimer;
        private JLabel label;
        private int messageIndex = -1;

        public FlashPane() {
            setLayout(new BorderLayout());
            add((label = new JLabel()));
            label.setHorizontalAlignment(JLabel.CENTER);

            flashTimer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    messageIndex++;
                    if (messageIndex >= MESSAGES.length) {
                        messageIndex = 0;
                    }
                    label.setText(MESSAGES[messageIndex]);
                }
            });
            flashTimer.setRepeats(true);
            flashTimer.setCoalesce(true);
            flashTimer.setInitialDelay(0);
            flashTimer.start();
        }

    }

}