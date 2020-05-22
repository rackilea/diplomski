import java.awt.Color; 
    import java.awt.Graphics; 
    import javax.swing.JPanel; 

    public class ShapePanel extends JPanel 
    { 

    public void paintComponent (Graphics g)
    { 
    super.paintComponent(g); 
    g.setColor(Color.green); 
    g.drawOval(0,0, 20, 20); 
    g.setColor(Color.yelow); 
    g.fillOval(0, 0, 15, 15); 
} 

    }