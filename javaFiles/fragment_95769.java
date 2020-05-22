ScrollableJTextArea()
{
    jTextArea.setLineWrap(true); // wrap text horizontally
    jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane.setPreferredSize(new Dimension(380,350));
    // and so on...
}