public LineJPanel() {
    setSize(500,500);
    Thread t = new Thread(){
         public void run(){
             while( true ) {
                 // add random lines and repaint
                 // sleep for a while
                 // and repeat.
            }
        }
    };
    t.start();
 }