public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("App");

        frame.setSize(1200, 800);//Give it a size
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new CardLayout());

        JPanel menu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel card1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel card2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        mainPanel.add(menu, "menu");
        mainPanel.add(card1, "card1");
        mainPanel.add(card2, "card2");

        JLabel l1 = new JLabel("label 1");
        JLabel l2 = new JLabel("label 2");
        card1.add(l1);
        card2.add(l2);
        JButton click = new JButton("Click!");
        menu.add(click);

        JScrollPane scrPane = new JScrollPane(mainPanel);
        frame.add(scrPane);

        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "card1");
            }
        });
        frame.setVisible(true);
    });
}