public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            Main frame = new Main();

            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

            JScrollPane scroller = new JScrollPane(container);
            scroller.setPreferredSize(new Dimension(200, 1000));

            for (Integer i = 0; i < 20; i++) {
                FixtureComponent fixture = new FixtureComponent();
                container.add(fixture);
            }

            frame.setLayout(new BorderLayout());
            frame.add(scroller, BorderLayout.WEST);
            frame.setSize(300, 400);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    });
}