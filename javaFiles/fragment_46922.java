final LinkedBlockingQueue<Character> sb = new LinkedBlockingQueue<Character>();

final JTextField t = new JTextField();
t.addKeyListener(new KeyListener() {
  @Override
  public void keyTyped(KeyEvent e) {
    sb.offer(e.getKeyChar());
  }
  ...
});

System.setIn(new BufferedInputStream(new InputStream() {
  @Override
  public int read() throws IOException {
    int c = -1;
    try {
      c = sb.take();            
    } catch(InterruptedException ie) {
    } 
    return c;           
  }
}));