import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class ProgressTabbedPane {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "RotatingIcon" );
        JTabbedPane tabbedPane = new JTabbedPane(  );
        tabbedPane.addTab( "Searching", new RotatingIcon( new ImageIcon( "resources/images/progress-indeterminate.png" ), tabbedPane ),
                           new JLabel( new ImageIcon( "resources/images/rotatingIcon.gif" ) ) );
        frame.getContentPane().add( tabbedPane );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
      }
    } );
  }

  private static class RotatingIcon implements Icon{
    private final Icon delegateIcon;
    private double angleInDegrees = 90;
    private final Timer rotatingTimer;
    private RotatingIcon( Icon icon, final JComponent component ) {
      delegateIcon = icon;
      rotatingTimer = new Timer( 100, new ActionListener() {
        @Override
        public void actionPerformed( ActionEvent e ) {
          angleInDegrees = angleInDegrees + 10;
          if ( angleInDegrees == 360 ){
            angleInDegrees = 0;
          }
          component.repaint();
        }
      } );
      rotatingTimer.setRepeats( false );
      rotatingTimer.start();
    }

    @Override
    public void paintIcon( Component c, Graphics g, int x, int y ) {
      rotatingTimer.stop();
      Graphics2D g2 = (Graphics2D )g.create();
      int cWidth = delegateIcon.getIconWidth() / 2;
      int cHeight = delegateIcon.getIconHeight() / 2;
      Rectangle r = new Rectangle(x, y, delegateIcon.getIconWidth(), delegateIcon.getIconHeight());
      g2.setClip(r);
      AffineTransform original = g2.getTransform();
      AffineTransform at = new AffineTransform();
      at.concatenate(original);
      at.rotate(Math.toRadians( angleInDegrees ), x + cWidth, y + cHeight);
      g2.setTransform(at);
      delegateIcon.paintIcon(c, g2, x, y);
      g2.setTransform(original);
      rotatingTimer.start();
    }

    @Override
    public int getIconWidth() {
      return delegateIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return delegateIcon.getIconHeight();
    }
  } 
}