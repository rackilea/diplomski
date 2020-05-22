public TextListener() {
    newText = new TextSource();
    jp1 = new JPanel();
    stuff = new JTextArea(45, 70);
    scroll = new JScrollPane(stuff);

    stuff.setEditable(false);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    jp1.setLayout(new FlowLayout());
    jp1.add(stuff);
    jp1.setBackground(Color.YELLOW);
    jp1.setVisible(true);

    JFrame yo = new JFrame();
    yo.add(jp1);
    yo.setVisible(true);
}