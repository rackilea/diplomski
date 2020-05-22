import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GalacticEngine1 implements  MouseMotionListener,KeyListener,GalacticConstants1 {
    public int ShipX=Ship_X;
    GalacticPanel p;


    public int getX() {return ShipX;}


    public void setPanel(GalacticPanel p)  {
        this.p = p;
    }

    GalacticEngine1(){
    }

    public void mouseDragged(MouseEvent e) {

    }
    public void mouseMoved(MouseEvent e) {
        int mouseX=e.getX();

        if(mouseX<ShipX&&ShipX<recW){
            ShipX-=Ship_Movement;
        }else if(mouseX>ShipX){
            ShipX+=Ship_Movement;
        }

        p.repaint();

    }

    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

}