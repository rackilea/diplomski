import java.awt.*;
import javax.swing.*;

public class Rect20degreeRotate extends JApplet{
public void init() {
 resize(500,500);

    Container DrawArea = getContentPane();
    DrawArea.add(

                new JPanel(){
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                      int x[]={0,80,80,0};
                      int y[]={0,0,50,50};
                  g2.translate( 100, 100);
                      for (int i=0;i<18;i++){
                    g2.rotate(20.0 * Math.PI / 180.0);
                    g2.drawPolygon(x,y,4);
                      }                         
                    }
            }
                );
}