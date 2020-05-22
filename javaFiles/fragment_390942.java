this.addWindowListener(new WindowAdapter()
 {
    @Override
    public void windowIconified(WindowEvent event) {
      //Hides it from screen
      Gui.this.setState(Frame.ICONIFIED);
      //Hides it from taskbar and screen
      Gui.this.setVisible(false);
    }
 });