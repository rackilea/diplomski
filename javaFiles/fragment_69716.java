window.addComponentListener(new ComponentAdapter() {
  @Override
  public void componentHidden(ComponentEvent e) {
    System.out.println("componentHidden()");
  }
})