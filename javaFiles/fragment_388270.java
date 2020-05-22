class MyCanvas extends JComponent {
    int a,b;
    public void setProps(int a, int b) {
        this.a=a; this.b=b;
        repaint();//mark this component to be repainted
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect (a, b, 200, 200);
    }

  static public void main(String args[]){
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    MyCanvas canvas=new MyCanvas();
    canvas.setProps(20,40);
    window.getContentPane().add(canvas);
    window.setVisible(true);
  }
}