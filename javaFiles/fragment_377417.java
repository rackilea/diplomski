import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;


public class CircleComponent extends JPanel  {

public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    //Rectangle rect= new Rectangle(50,100,100,100);
    g2.setColor(Color.RED);
    g2.fillRect(50,100,100,100);
    g2.setColor(Color.ORANGE);
    g2.fillRect(50,80,100,30);
    g2.setColor(Color.BLUE);
    g2.fillRect(100,150,30,50);
    g2.setColor(Color.WHITE);
    g2.fillOval(120,180,7,7);
    //Point2D.Double p = Tester.p;
    g2.setColor(Color.CYAN);
    g2.fillRect(120,31,30,50);
}

public static void main(String[] args) {
    JFrame frame = new JFrame("Jframe");
    CircleComponent a = new CircleComponent();
    frame.add(a);
    frame.setSize(250,250);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.black);

}


}