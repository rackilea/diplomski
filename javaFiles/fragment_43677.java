import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimateRectangle {

    private JFrame frame;

    public AnimateRectangle(Model model){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new MyJPanel(model);
        panel.setDoubleBuffered(true);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    void refresh() {
        frame.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller(400, 400);
        while (true) {
            Thread.sleep(1000);
            SwingUtilities.invokeLater(()->controller.animate());
        }
    }
}

//"wires" gui and model 
class Controller{

    private Model model;
    private AnimateRectangle view;

    Controller(int sizeX, int sizeY){

         model = new Model(sizeX, sizeY);
         view = new AnimateRectangle(model);
    }

    void animate() {
        int newAngle = (model.getAngle() < 360 ) ? model.getAngle()+1 : 0 ;
        model.setAngle(newAngle);
        view.refresh();
    }
}

//represents the inforamtion the GUI needs 
class Model{

    int sizeX, sizeY, angle = 0;

    public Model(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    int getSizeX() { return sizeX; }

    int getSizeY() {return sizeY;}

    int getAngle() {return angle;}

    //degrees
    void setAngle(int angle) {  this.angle = angle; }
}

//a JPanel with custom paint component 
class MyJPanel extends JPanel {

    private Model model;

    public MyJPanel(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(model.getSizeX(), model.getSizeY()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        int sizeX = model.getSizeX(), sizeY = model.getSizeY();
        g2d.rotate(Math.toRadians(model.getAngle()), sizeX /2, sizeY/2);
        g2d.fillRect(sizeX/4, sizeY/4, sizeX/2, sizeY/2);
    }
}