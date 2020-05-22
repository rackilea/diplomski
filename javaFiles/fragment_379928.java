class Outer {
  void initUI() {
    JFrame.addKeyListener( new InnerKeyListener( myParam ) );
  }

  class InnerKeyListener implements KeyListener {
    InnerKeyListener( Param p ) {
    }

    ...
  }
}