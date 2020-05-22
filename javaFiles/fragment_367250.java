public void init() {
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(0, 2)); // a left and right panel

    JPanel drawPanel = new JPanel(new BorderLayout());
    drawPanel.setBackground(Color.BLACK);
    JLabel headerLabel = new JLabel("Draw shapes from another class");
    headerLabel.setForeground(Color.GREEN);
    drawPanel.add(headerLabel,BorderLayout.EAST);
    circle.setBackground(Color.BLACK);
    drawPanel.add(circle);

    JPanel textPanel = new JPanel(new BorderLayout()); // right panel for text
    JTextArea output = new JTextArea("Circle and oval");
    textPanel.add(new JScrollPane(output));

    mainPanel.add(drawPanel);
    mainPanel.add(textPanel);
    add(mainPanel);
    setSize(600,200);
}