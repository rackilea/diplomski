class Outer {
  int x;

  void initUI( final int z) {
    final int y = 0;        
    int nope = 1; //you can't access this since it is neither final nor a field like x

    JFrame.addKeyListener( new KeyListener() {
      public void keyTyped(KeyEvent evnt) {
        System.out.println( x + y + z ); //you can access all of them
      }
    });
  }
}