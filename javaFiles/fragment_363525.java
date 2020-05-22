private void jmiFullscreenActionPerformed(java.awt.event.ActionEvent evt) {
    GraphicsDevice gd = this.gameFrame.getGraphicsConfiguration().getDevice();

    if (gd.getFullScreenWindow() != null) {
        gd.setFullScreenWindow(null);
        this.gameFrame.setResizable(true);
        this.gameFrame.setPreferredSize(new Dimension(400, 300));
    } else {
        this.gameFrame.setResizable(false);
        this.gameFrame.setPreferredSize(new Dimension(gd.getDefaultConfiguration().getBounds().getSize()));
        this.gameFrame.enableInputMethods(false);
        gd.setFullScreenWindow(this.gameFrame);
    }
    refresh();
}