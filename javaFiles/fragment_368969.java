import java.awt.*;
    import java.awt.event.*;
    import java.awt.geom.*;
    import javax.swing.*;

    public class Testing extends JPanel implements ActionListener {
       private int x, y, xinc, yinc;



       public void paintComponent(Graphics g) {
          // added this statement.
          super.paintComponent(g);
          Graphics2D gimg = (Graphics2D) g;

          Rectangle2D rect = new Rectangle2D.Double(50, 50, 10, 300);

          CubicCurve2D cub1 =
                new CubicCurve2D.Double(60, 50, x, 10, y, 100, 200, 50);
          gimg.draw(cub1);

          CubicCurve2D cub2 =
                new CubicCurve2D.Double(60, 100, x, 60, y, 150, 200, 100);
          gimg.draw(cub2);

          CubicCurve2D cub3 =
                new CubicCurve2D.Double(60, 150, x, 110, y, 200, 200, 150);
          gimg.draw(cub3);

          Line2D l1 = new Line2D.Double(200, 50, 200, 150);
          gimg.draw(l1);

          GeneralPath gp1 = new GeneralPath();
          GeneralPath gp2 = new GeneralPath();

          gp1.moveTo(60, 50);
          gp1.curveTo(x, 10, y, 100, 200, 50);
          gp1.lineTo(200, 100);
          gp1.curveTo(y, 150, x, 60, 60, 100);
          gp1.lineTo(60, 50);

          gimg.setColor(Color.WHITE);

          gimg.fill(gp1);

          gimg.setColor(Color.GRAY);

          gimg.fill(rect);

          gp2.moveTo(60, 100);
          gp2.curveTo(x, 60, y, 150, 200, 100);
          gp2.lineTo(200, 150);
          gp2.curveTo(y, 200, x, 110, 60, 150);
          gp2.lineTo(60, 100);

          gimg.setColor(Color.RED);

          gimg.fill(gp2);
       }

       public void moveFlag() { // waving animation
          Timer timer = new Timer(20, this);
          timer.start();
          // moved the next four statements from paintComponents.  They
          // are initializations.  In paintComponent you kept resetting them.
          xinc = 10;
          yinc = 10;
          x = 101;
          y = 151;

          repaint();
       }

       @Override
       public void actionPerformed(ActionEvent e) {
         //moved all of these from moveFlag to here. This is called by
         //the timer event to update the x and y coordinates.
          x = x + xinc;
          y = y + yinc;

          if (x <= 60 || (x + xinc) >= 130)
             xinc *= -1;

          if (y <= 50 || (y + yinc) >= 230)
             yinc *= -1;

          // revalidate();
          repaint();
       }

      public static void main(String[] args) {
          JFrame frame = new JFrame();

          Testing test = new Testing();
          frame.setContentPane(test);
          frame.setSize(500, 500);
          frame.setVisible(true);

          test.moveFlag();
       }
    }