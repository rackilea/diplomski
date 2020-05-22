import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
public class Board extends JPanel {
Area area;
void go( Area area ) {
    this.area = area;
    JFrame frame = new JFrame("Circle Test");
    frame.getContentPane().add(this);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    repaint();
    frame.setPreferredSize(new Dimension(800,800));
    frame.pack();
    frame.setVisible(true);
}

public void paintComponent(Graphics g) {
  AffineTransform at = new AffineTransform();
  at.translate( 100, 100 );
  at.scale( 50, 50 );
  PathIterator pit = area.getPathIterator( at );
  Path2D path = new Path2D.Double();
  path.append( pit, true );
  Graphics2D g2d = (Graphics2D)g;
  g2d.draw( path );
}
}