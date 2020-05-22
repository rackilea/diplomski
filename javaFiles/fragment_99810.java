import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Test extends JFrame{

    //when posting code make resources available
    URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");

    public Test() throws IOException  {

        //You clearly have three different areas in your design, so start by making:
        JPanel left = new JPanel();
        JPanel center = new JPanel();
        JPanel right = new JPanel();

        //left and right panels holds 4 buttons each. GridLayout will make
        //them occupy equal space. You could also use other layout managers like
        //Box
        left.setLayout ( new GridLayout ( 4, 1 ) );  //4 Rows and 1 Columns
        //Button 1
        left.add ( new JButton ( "Button 1" ) );
        //Button 2
        left.add ( new JButton ( "Button 2" ) );
        //Button 3
        left.add ( new JButton ( "Button 3" ) );
        //Button 4
        left.add ( new JButton ( "Button 4" ) );

        //Create a border layout - This will go in the middle.
        center.setLayout ( new BorderLayout() );
        //Label - Welcome to my application
        center.add ( new JLabel ( "Welcome to my application"),BorderLayout.NORTH);
        //Image 1
        ImageIcon icon= new ImageIcon(ImageIO.read(url));
        center.add ( new JLabel(icon), BorderLayout.CENTER);

        //Create a grid layout - This will go to the right
        right.setLayout ( new GridLayout ( 4, 1 ) ); //4 Rows and 1 Columns
        //Button 5
        right.add ( new JButton ( "Button 5" ) );
        //Button 6
        right.add ( new JButton ( "Button 6" ) );
        //Button 7
        right.add ( new JButton ( "Button 7" ) );
        //Button 8
        right.add ( new JButton ( "Button 8" ) );

        //add JPanel to content pane which uses Borderlayout by default
        getContentPane().add(left, BorderLayout.WEST);
        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(right, BorderLayout.EAST);

        //Set window parameters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle ( "Test Application" );
        //setSize ( 200, 200 ); //size set by layout
        pack();
        setVisible ( true );
    }

    public static void main ( String[] args ) throws IOException   {
        new Test();
    }//End main
}//End Class