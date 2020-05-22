import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class MainTest2 {
  public static void main(String[] args) {
    CWTEST frame = new CWTEST("Digital Doily");
    frame.initialiseGUI();
  }
}

class CWTEST extends JFrame {

  public CWTEST(String title) {
    super(title);
  }

  public void initialiseGUI() {
    Container mainPanel = this.getContentPane();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //make the window as big as the screen without covering the windows taskbar
    this.setBounds(0, 0, screenSize.width, screenSize.height - 40);

    //set up the displayPanel where the drawing is done
    mainPanel.setLayout(new BorderLayout());
    DrawingPanel displayPanel = new DrawingPanel();
    mainPanel.add(displayPanel, BorderLayout.CENTER);

    //set up the controlPanel where the user changes the drawing options
    JPanel controlPanel = new JPanel();
    mainPanel.add(controlPanel, BorderLayout.SOUTH);
    controlPanel.setLayout(new FlowLayout());
    controlPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));


    JLabel reflectPointsLabel = new JLabel("reflect points");
    controlPanel.add(reflectPointsLabel);

    JCheckBox reflectPointsBox = new JCheckBox();
    reflectPointsBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          displayPanel.reflectPoints = true;
        } else {
          displayPanel.reflectPoints = false;
        }
      }
    });
    controlPanel.add(reflectPointsBox);
    reflectPointsBox.setSelected(false);



    this.setVisible(true);

    //once the frame is visible we can get the real size of the drawing panel and create a buffered image that matches it
    displayPanel.buffImage = new BufferedImage(
        displayPanel.getWidth(), displayPanel.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
  }




  public class DrawingPanel extends JPanel {
    //default drawing options
    private double circleDiameter = 5;
    private Color color = Color.BLUE;
    private boolean showSectors;
    private boolean reflectPoints;
    private int numOfSectors = 12;
    //list of points to be drawn
    private ArrayList<MyPoint> pointsList;
    //buffered image on which the drawing is done and then copied to the JPanel
    private BufferedImage buffImage;

    public DrawingPanel() {
      this.setBackground(Color.BLACK);
      DrawingListener listener = new DrawingListener(this);
      this.addMouseListener(listener);
      this.addMouseMotionListener(listener);
      this.addComponentListener(listener);
      pointsList = new ArrayList<MyPoint>();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.drawBuffImage();
      //copy what's drawn on the buffered image to the JPanel
      g.drawImage(buffImage, 0, 0, null);
    }

    public void drawBuffImage() {
      Graphics2D g2d = buffImage.createGraphics();
      g2d.setColor(Color.WHITE);

////if there are more tan 1 sectors - draw lines to separate them
//if (showSectors && numOfSectors > 1) {
//    Line2D line = new Line2D.Double(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight() / 2);
//
//    //draw half a line every time and rotate the next according to the number of sectors
//    for (int w = 0; w < numOfSectors; w++) {
//        g2d.draw(line);
//        g2d.rotate(Math.toRadians((double) 360 / numOfSectors), this.getWidth() / 2, this.getHeight() / 2);
//    }
//    g2d.rotate(0d);
//}

      double angle = 360d / numOfSectors;
      double ancx  = this.getWidth() / 2d;
      double ancy  = this.getHeight() / 2d;

      //draw each point in the list
      for (int i = 0; i < pointsList.size(); i++) {
        MyPoint point = pointsList.get(i);
        g2d.setColor(point.getPointColor());

        Ellipse2D circle = new Ellipse2D.Double(
            point.getX(), point.getY(), point.getPointDiameter(), point.getPointDiameter());

        //draw the point once in each sector
        double rotate = 0d;
        for (int j = 0; j < numOfSectors; j++) {
          rotate += angle;
          AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rotate), ancx, ancy);
          g2d.fill(at.createTransformedShape(circle));
          //g2d.rotate(Math.toRadians(((double) 360 / numOfSectors)), this.getWidth() / 2, this.getHeight() / 2);
        }

        //if point should be reflected, draw its reflection in each sector
        if (point.isReflected()) {
          //g2d.rotate(Math.toRadians((double) 360 / (numOfSectors * 2)), this.getWidth() / 2, this.getHeight() / 2);
          //g2d.fill(circle);
          rotate = angle / 2d;
          g2d.setColor(Color.RED);
          for (int t = 0; t < numOfSectors; t++) {
            //g2d.rotate(Math.toRadians((double) 360 / numOfSectors), this.getWidth() / 2, this.getHeight() / 2);
            //g2d.fill(circle);
            rotate += angle;
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rotate), ancx, ancy);
            g2d.fill(at.createTransformedShape(circle));
          }
        }
      }
      g2d.dispose();
    }

    public void wipeScreen() {
      //wipe everything by covering it with black
      if (buffImage != null) {
        Graphics g = buffImage.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, buffImage.getWidth(), buffImage.getHeight());
        g.dispose();
      }
    }

    public void addPoint(MyPoint p) {
      pointsList.add(p);
    }

    public void setColor(Color color) {
      this.color = color;
    }

    public void setCircleDiameter(double circleDiameter) {
      this.circleDiameter = circleDiameter;
    }
  }

  public class DrawingListener extends MouseAdapter implements ComponentListener {
    //the panel on which the user draws
    private final DrawingPanel dPanel;

    public DrawingListener(DrawingPanel dPanel) {
      this.dPanel = dPanel;
    }

    //add a point to the arraylist every time the user draws, and draw
    public void mousePressed(MouseEvent e) {
      //System.out.println(e.getPoint());
      dPanel.addPoint(new MyPoint(e.getX(), e.getY(), dPanel.color, dPanel.circleDiameter, dPanel.reflectPoints));
      dPanel.repaint();
    }

    public void mouseDragged(MouseEvent e) {
      dPanel.addPoint(new MyPoint(e.getX(), e.getY(), dPanel.color, dPanel.circleDiameter, dPanel.reflectPoints));
      dPanel.repaint();
    }

    @Override
    public void componentResized(ComponentEvent e) {
      //whenever component is resized, wipe the screen
      //then the system-triggered repaint occurs and the result is that by making the window smaller, the user zooms in
      dPanel.wipeScreen();
    }

    public void componentHidden(ComponentEvent arg0) {}
    public void componentMoved(ComponentEvent arg0) {}
    public void componentShown(ComponentEvent arg0) {}
  }


  //each point drawn is an object of the class
  public class MyPoint extends Point {
    private Color pointColor;
    private double pointDiameter;
    private boolean reflected;

    public MyPoint(int x, int y, Color c, double pointDiameter, boolean reflected) {
      super(x, y);
      this.pointColor = c;
      this.pointDiameter = pointDiameter;
      this.reflected = reflected;
    }

    public Color getPointColor() {
      return this.pointColor;
    }

    public double getPointDiameter() {
      return this.pointDiameter;
    }

    public boolean isReflected() {
      return this.reflected;
    }
  }
}