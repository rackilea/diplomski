import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
@SuppressWarnings("serial")
public class Galactic extends JFrame implements GalacticConstants1 {
//    private ImageIcon windowicon=new ImageIcon(getClass().getResource("galactic ship.jpg"));
    private ImageIcon windowicon=new ImageIcon("file:blah","");
    Galactic(){
        galacticComponents();
    }
    private void galacticComponents() {
        setIconImage(windowicon.getImage());
        panel();
    }
    private void panel(){
        GalacticEngine1 ge=new GalacticEngine1();
        GalacticPanel g1=new GalacticPanel();
        ge.setPanel(g1);
        g1.setEngine(ge);
        add(g1);

        g1.addMouseMotionListener(ge);
        g1.addKeyListener(ge);
    }
    public static void main(String[] args) {
        Galactic g=new Galactic();
        //Initializing game
        g.setSize(d);
        //setting the game size
        g.setTitle("Galactic Ship");
        //setting the game title
        g.setVisible(true);
        //the visibility
        g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //what to do when the close button is pressed
        g.setResizable(false);
        //if the window can be resized
        g.setLocationRelativeTo(null);
        //the location on the screen
    }

}