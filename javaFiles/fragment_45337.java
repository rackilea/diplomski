public void Draw(){
  BufferStrategy bs = this.getBufferStrategy();
  if(bs==null){
    createBufferStrategy(2);
  } else {
    Graphics g = bs.getDrawGraphics();
    g.setColor(Color.BLACK);
    g.fillOval(ball.BallLocationX, ball.BallLocationY, 20, 20);
    g.dispose();
    bs.show();
  }
}