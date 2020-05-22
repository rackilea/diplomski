package paint;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class NPaintMouseEvents implements MouseListener, MouseMotionListener {

    NPaintCanvas canvas;

    public NPaintMouseEvents(NPaintCanvas canvas) {
      this.canvas = canvas;
      this.canvas.addMouseMotionListener(this);
      this.canvas.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      if (canvas.actualPoint == null) {
         canvas.actualPoint = new Point();
      }
      canvas.actualPoint.x = e.getPoint().x;
      canvas.actualPoint.y = e.getPoint().y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
      canvas.mousePressed((int) e.getX(), (int) e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      canvas.mouseReleased();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}