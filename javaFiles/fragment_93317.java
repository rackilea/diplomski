import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class Test extends javax.swing.JPanel {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
    }
        GlobalVar obj = new GlobalVar();

     @Override
        public void paintComponent(Graphics g)
        {       

          if(g instanceof Graphics2D) {
           // Recover Graphics2D
           Graphics2D g2 = (Graphics2D) g;

           // Construct a rectangle and draw it
           Rectangle box1 = new Rectangle(2, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box1);
           g2.setColor(obj.fillColor1);
           g2.fill(box1);

           Rectangle box2 = new Rectangle(77, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box2);
           g2.setColor(obj.fillColor2);
           g2.fill(box2);

           Rectangle box3 = new Rectangle(152, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box3);
           g2.setColor(obj.fillColor3);
           g2.fill(box3);

           Rectangle box4 = new Rectangle(227, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box4);
           g2.setColor(obj.fillColor4);
           g2.fill(box4);

           Rectangle box5 = new Rectangle(302, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box5);
           g2.setColor(obj.fillColor5);
           g2.fill(box5);

           Rectangle box6 = new Rectangle(377, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box6);
           g2.setColor(obj.fillColor6);
           g2.fill(box6);

           Rectangle box7 = new Rectangle(452, 2, 71, 71);
           g2.setColor(Color.BLACK);
           g2.draw(box7);
           g2.setColor(obj.fillColor7);
           g2.fill(box7);

           g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

           Font f = new Font("Dialog", Font.PLAIN, 30);
           g2.setFont(f);
           g2.setColor(Color.BLACK);
           g2.drawString("1", 30, 48);
           g2.drawString("2", 105, 48);
           g2.drawString("3", 180, 48);
           g2.drawString("4", 255, 48);
           g2.drawString("5", 330, 48);
           g2.drawString("6", 405, 48);
           g2.drawString("7", 480, 48);
          }

        }

        private Color fillColor1;
        private Color fillColor2;
        private Color fillColor3;
        private Color fillColor4;
        private Color fillColor5;
        private Color fillColor6;
        private Color fillColor7;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
                GlobalVar obj = new GlobalVar();
                obj.fillColor1 = obj.farben[1];
                repaint();
        // TODO add your handling code here:
    }                                 


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}