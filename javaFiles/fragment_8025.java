public TextListener() {
    newText = new TextSource();
    stuff = new JTextArea(45, 70);
    scroll = new JScrollPane(stuff);

    stuff.setEditable(false);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    setLayout(new FlowLayout());
    add(stuff);
    setBackground(Color.YELLOW);
}