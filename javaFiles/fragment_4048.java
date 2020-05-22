public void aiMove(){
  if (!playing){ return; } 
  if (!aiThread.isAlive()){  //originally initialized by constructor
    aiThread = new Thread(){
      public void run(){
            ai = eve.getMove(chess,wtm,aiOut);
            chess.makeMove(ai);
            wtm = !wtm;
            humanMove = true;
        SwingUtilities.invokeLater(new Runnable(){
          public void run(){
            writeMove(ai);
          }
        });
        repaint();
        playing = stillPlaying();
      }
    };
    aiThread.start();
  }
}