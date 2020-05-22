public void changePanel(CBPanel panel){
    JComponent jComponent = null;
    if(panel instanceof JComponent) {
        jComponent = (JComponent) panel;
    }
    // if you want LoginPanel then you can cast it to it if it is a subtype of it
    LoginPanel loginPanel = null;
    if(panel instanceof LoginPanel ) {
        loginPanel = (LoginPanel) panel;
    }
    mainFrame.setContentPane();
    mainFrame.setMinimumSize(panel.getMinSize());
    mainFrame.setResizable(panel.canResize());
}