public class Olympic extends JApplet{

    public void init(){
        getContentPane().setBackground(Color.WHITE);    
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawOval(0,0,10,10);
    }
}