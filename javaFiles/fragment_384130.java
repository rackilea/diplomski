import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.Image;
    import java.awt.Toolkit;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.WindowConstants;

    //public class JBallonPanel extends JPanel implements Runnable {
    //You can remove implements Runnable
    public class JBallonPanel extends JPanel {
    private Image img;
    private int x, y;

    JBallonPanel(){
        setBackground(Color.white);
        // your path should have \\ for example C:\\Ball.jpg or C:\\myImageFolder\\Ball.jpg 
        // but in your case, it works too.
        img=Toolkit.getDefaultToolkit().createImage("C:\\Ball.jpg");
        x=this.getWidth()/2;
        y=this.getHeight()/2;
    }

    public void paintComponent(Graphics g){
        g.drawImage(img, x, y, img.getWidth(this), img.getWidth(this),     this);
    }

    //And run like this
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JBallonPanel());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}