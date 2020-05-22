import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class FRMMain extends JFrame {
  private final List<Shape> list=new ArrayList<>();
  private boolean paintPhase=true;

  public FRMMain() {
      this.setUndecorated(true);
      final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setSize(screenSize.width, screenSize.height);
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.setBackground(new Color(0, 0, 0, 1));
      this.setOpacity(1f);
      this.setAlwaysOnTop(true);
      this.setVisible(true);
      enableEvents(AWTEvent.MOUSE_EVENT_MASK|AWTEvent.MOUSE_MOTION_EVENT_MASK);
  }
  @Override
  protected void processMouseEvent(MouseEvent e) {
    if(paintPhase && e.getID()==MouseEvent.MOUSE_RELEASED) {
      paintPhase = false;
      // on my machine the following line is enough to enable click-through
      setBackground(new Color(0, 0, 0, 0));
      // but if this doesn’t work, the following should do:
      Area area=new Area();
      BasicStroke b=new BasicStroke(2f);
      for(Shape s:list) area.add(new Area(b.createStrokedShape(s)));
      setShape(area);
    }
    super.processMouseEvent(e);
  }
  @Override
  protected void processMouseMotionEvent(MouseEvent event)
  {
    if(paintPhase && event.getID()==MouseEvent.MOUSE_DRAGGED) {
      int x = event.getX();
      int y = event.getY();
      list.add(new Ellipse2D.Float(x, y, 8, 8));
      repaint();
    }
    super.processMouseMotionEvent(event);
  }
  @Override
  public boolean contains(int x, int y) {
    return paintPhase;
  }

  public static void main(String[] args) {
      new FRMMain();
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D gfx=(Graphics2D)g;
    gfx.setColor(Color.RED);
    for(Shape s:list) gfx.draw(s);
  }
}