static int direction = -4;
    static final boolean useScroll = true;
    static final String longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                                             + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    public static void main(String[] args) {
        JFrame test = new JFrame("Test");
        test.setSize(500, 300);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        test.setLayout(new BoxLayout(test.getContentPane(), BoxLayout.Y_AXIS));
        for (int i = 0; i < 10; i++) {
            if(useScroll) {
                JScrollPane jScrollPane = new JScrollPane(new JLabel(longString));
                jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                jScrollPane.setMaximumSize(new Dimension(1000, 50));
                jScrollPane.setPreferredSize(new Dimension(0, 50));
                test.add(jScrollPane);
            } else {
                 test.add(new JLabel(longString));
            }
        }
        test.add(Box.createVerticalGlue()); //should use all available space

        final int min = 300, max = 600;
        new Timer(50, e -> {
            int h = test.getHeight();
            SwingUtilities.invokeLater(() -> test.setSize(test.getWidth(), h + direction));
            direction = h == min || h == max ? -direction : direction;
        }).start();

        test.setVisible(true);
    }