import java.awt.*;
    import java.awt.event.*;
    import java.awt.geom.*;
    import java.util.*;

public class ZakCurve extends Frame {



          public static void main(String[] a){
              (new ZakCurve()).setVisible(true);
              GeneralPath g=new GeneralPath();
          }
          ZakCurve(){
              super("Test");
               setSize(500, 500);
               addWindowListener(new WindowAdapter() {
                 public void windowClosing(WindowEvent e) {
                   System.exit(0);
                 }
               });
             }


           @SuppressWarnings("unused")
        public void paint(Graphics g) {
               Graphics2D g2d = (Graphics2D) g;
               g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

               GeneralPath path=new GeneralPath();

               path.moveTo(457.61616,470.82943 );                 
               path.curveTo(458.41016,425.70843 ,427.74316,392.55343 ,403.93516,370.91243 );
               path.curveTo(399.48516,366.83843 ,398.54916,368.02743 ,397.41516,372.27043 );
               path.curveTo(394.75116,382.25643 ,392.96616,392.69543 ,391.09516,402.03043 );
               path.curveTo(390.35916,405.62343 ,389.79116,406.92443 ,392.62616,409.52743 );
               path.curveTo(406.00316,421.83343 ,442.19716,458.07143 ,444.89016,482.76843 );
               path.curveTo(431.76716,528.31343 ,393.39116,574.56743 ,350.22516,594.56743 );
               path.curveTo(316.63916,610.12643 ,278.88716,614.34043 ,242.18316,610.35243 );
               path.curveTo(232.12112,609.27843 ,228.38012,619.29143 ,238.47016,621.92243 );
               path.curveTo(274.01216,631.28543 ,320.32416,637.73643 ,356.57416,628.91043 );
               path.curveTo(420.03416,613.46343 ,456.48216,533.71643 ,457.61616,470.82943);  

               path.closePath();
               g2d.draw(path);
               g2d.fill(path);
}       
}