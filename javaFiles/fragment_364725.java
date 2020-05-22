class MyPanel extends JPanel {

  public MyPanel() {
     super();
     this.initialize();
  }

  public MyPanel(LayoutManager manager) {
     super(manager);
     this.initialize();
     // Do the rest of the stuff
  }

  protected void initialize() {
     // Do common initialization
  }

}