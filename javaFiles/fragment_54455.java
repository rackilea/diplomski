import java.awt.*;
import javax.swing.*;
public class MyClass extends JPanel {
    private JLayeredPane layeredPane;
    private JLabel imageContainer = new JLabel();
    private JButton info = new JButton("i");

    MyClass(ImageIcon image) {
        super();

        this.imageContainer.setIcon(image);

        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 300));
        layeredPane.add(imageContainer, new Integer(50));
        layeredPane.add(info, new Integer(100));
        this.add(layeredPane);
        // CHANGED CODE
        // Manually set layout the components. 
        imageContainer.setBounds( 0, 0,  
                                  image.getIconWidth(),
                                  image.getIconHeight() ); 
        info.setBounds( 200, 00,  50, 40 );
    }
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new MyClass( new ImageIcon("logo.png")  ) );
        frame.pack();
        frame.setVisible( true );
    }
}