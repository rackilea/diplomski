private Component initScrollPane() {
    scrollPaneContainer = new JPanel( new BorderLayout() );
    boxHolder = Box.createVerticalBox(); 
    scrollPaneContainer.add(boxHolder, BorderLayout.PAGE_START);
    JScrollPane jSP = new JScrollPane(scrollPaneContainer);
    jSP.getVerticalScrollBar().setUnitIncrement(16);
    return jSP;
}