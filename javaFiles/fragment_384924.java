private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    jPanelSecond.setVisible(true);
    Rectangle viewBounds = jScrollPaneFirst.getViewportBorderBounds();
    Dimension size = jPanelMain.getPreferredSize();
    jPanelMain.scrollRectToVisible(new Rectangle(0, size.height, viewBounds.width, viewBounds.height));
    //jScrollPaneFirst.getVerticalScrollBar().setValue(280);
}