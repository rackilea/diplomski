JScrollPane pane = new JScrollPane();
pane.setViewport(
  new JViewport(){
    /**
     * An empty override implementation to prevent undesired scrolling on
     * size changes of the client.
     */
     @Override
     public void scrollRectToVisible(Rectangle rect){}
  });