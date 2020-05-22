public LayoutTest()
{
    setSize(50, 200);
    setLocation(MouseInfo.getPointerInfo().getLocation());

    final JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JButton okButton = new JButton("Save");
    JPanel wrapper = new JPanel();
    wrapper.add(okButton);

    JTextArea textArea = new JTextArea(5,1);
    textArea.setWrapStyleWord(true);
    textArea.setLineWrap(true);
    textArea.setEditable(true);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    scrollPane.setMaximumSize(new Dimension(Short.MAX_VALUE, 150));

    panel.add(scrollPane);
    panel.add(wrapper);
    panel.add(Box.createVerticalGlue());
    panel.setBorder(BorderFactory.createLineBorder(Color.red));
    add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}