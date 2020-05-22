import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnaPencere {
    JFrame anaPencere;
    BufferedImage bImageLEFT;
    BufferedImage bImageRIGHT;
    public static void main(String[] args){
        AnaPencere apencere = new AnaPencere();
    }

    public AnaPencere() {
            anaPencere = new JFrame("Main Window");
            anaPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            anaPencere.setSize(613, 253);
            anaPencere.setLocationRelativeTo(null);
            JPanel pLeft = new left();
            JPanel pRight = new right();
            anaPencere.getContentPane().add(pLeft,BorderLayout.WEST);
            anaPencere.getContentPane().add(pRight,BorderLayout.EAST);
            anaPencere.setVisible(true);//Set visible true after all components are added
    }

    private class left extends JPanel{
        private left() {
            //this.setBounds(0, 0, 313, 253);//Don't set Bounds. Use Layouts provided by Swing API
            setPreferredSize(new Dimension(150,200));//Set the preferredSize
            this.setFocusable(true);
            bImageLEFT = new BufferedImage(313, 253, BufferedImage.TYPE_INT_ARGB);
            //paintComponent(bImageLEFT.createGraphics());// No need to call it explicitly. Swing will do it for itself.
        }

   public void paintComponent(Graphics g){
        super.paintComponent(g);//call the paintComponent method of JPanel class
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(new Font(g.getFont().getName(),Font.BOLD,13));//set Font in this way
        g2.drawString(">  LEFT  <", 10, 20);//10 is x coordinate , 20 is y cordinate
    }
    }

    private class right extends JPanel{
        private right() {
            //this.setBounds(313, 0, 300, 253);/Don't set Bounds. Use Layouts provided by Swing API
            setPreferredSize(new Dimension(150,200));//Set the preferredSize
            this.setFocusable(true);
            bImageRIGHT = new BufferedImage(313, 253, BufferedImage.TYPE_INT_ARGB);
           // paintComponent(bImageRIGHT.createGraphics());//No need to call it explicitly. It is called by swing components itself.
        }

        public void paintComponent(Graphics g){
             super.paintComponent(g);//call the paintComponent method of JPanel class
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(new Font(g.getFont().getName(),Font.BOLD,13));//set Font in this way
            g2.drawString(">  RIGHT  <", 10, 20);//10 is x coordinate , 20 is y cordinate
        }
    }
}