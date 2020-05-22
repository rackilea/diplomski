static class MainPanel extends JPanel {
    public MainPanel(final Container frame) {
        add(new JButton(new AbstractAction("Click to view next") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(new NextPanel(), "NextPanel");
                ((CardLayout) frame.getLayout()).show(frame, "NextPanel");
            }
        }));
    }
}

static class NextPanel extends JPanel {
    public NextPanel() {
        add(new JLabel("Next page in the card layout"));
    }
}

public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("Test");
    frame.setLayout(new CardLayout());
    frame.add(new MainPanel(frame.getContentPane()), "MainPanel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}