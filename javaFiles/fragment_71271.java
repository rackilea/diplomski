import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Askisi2_3 extends JFrame {

    public Askisi2_3() {
        initialiseComponents();
    }

    private void initialiseComponents() {
        JPanel panel = new LineJPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(500, 500);
        setVisible(true);
    }
    public static void main( String [] args ) {
        new Askisi2_3();
    }
}
// line abstraction
class Line {
    int x1, y1, x2, y2;
}
class LineJPanel extends JPanel {
    // this is the private model
    private Line[] lines = new Line[10];// fixed of size 10 by now.
    // private internal index position
    private int count = 0;

    // generates "random" numbers
    private Random random = new Random();

    // create the panel and start adding more lines in a separate thread.
    public LineJPanel() {
        setSize(500,500);

        Thread t = new Thread(){
            public void run(){
                // forever:
                while( true ){
                    //add another line
                    addRandomLine();
                    // rapaint it
                    SwingUtilities.invokeLater( new Runnable(){
                        public void run(){
                            repaint();
                        }
                    });
                    // sleep for while
                    try{
                        Thread.sleep( 1000 );
                    }catch( InterruptedException ie ){}
                }
            }
        };
        t.start();
    }
    // just draw the model
    private void drawRandomLines(Graphics g) {
        for( Line line : lines ){
            if( line != null ){ 
                g.drawLine( line.x1, line.y1, line.x2, line.y2 );
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRandomLines(g);
    }
    // add another line to the "model"
    private void addRandomLine(){
        Line line = new Line();
        line.x1  = random.nextInt(500);
        line.y1  = random.nextInt(500);
        line.x2  = random.nextInt(500);
        line.y2  = random.nextInt(500);
        lines[count++] = line;
        if( count == lines.length ){
            count = 0;
        } 
    }

}