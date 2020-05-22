SwingUtilities.invokeLater(new Runnable() {
  private final WindowListener l = new WindowAdapter() {
    @Override
    public void void windowDeiconified(WindowEvent e) {
      // Window now deiconified so bring it to the front.
      bringToFront();

      // Remove "one-shot" WindowListener to prevent memory leak.
      frame.removeWindowListener(this);
    }
  };

  public void run() {
    if (frame.getExtendedState() == Frame.ICONIFIED) {
      // Add listener and await callback once window has been deiconified.
      frame.addWindowListener(l);
      frame.setExtendedState(Frame.NORMAL);
    } else {
      // Bring to front synchronously.
      bringToFront();
    }
  }

  private void bringToFront() {
    frame.getGlassPane().setVisible(!frame.getGlassPane().isVisible());
    frame.toFront();
    // Note: Calling repaint explicitly should not be necessary.
  }
});