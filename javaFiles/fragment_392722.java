JDesktopPane desktop;
public IFrameOne(JDesktopPane desktop) {
    initComponents();
    this.desktop = desktop;
}
...
private void jButton1ActionPerformed(ActionEvent evt) {                                         
    IFrameTwo iFrameTwo = new IFrameTwo();
    desktop.add(iFrameTwo);
    this.dispose();
    iFrameTwo.setVisible(true);
}