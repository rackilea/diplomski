public class Game extends JPanel implements MouseMotionListener {
    public void run() {
        addMouseMotionListener(this);
        //...        
    }
    public void mouseMoved(MouseEvent e) {                  
        paddle.move(e.getX()-paddle.getX(), 0); 
    } 
    //...
};