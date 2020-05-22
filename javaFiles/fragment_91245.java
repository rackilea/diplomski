import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.border.Border;

public class Iframe extends JFrame implements ActionListener {

    private static final String PATH = "E:/NetBeans/Pentahex-Game/src/pentahex/game/";

    HashMap<String, int[]> pentahexMap = new HashMap<String, int[]>() {{

        put( "Clear",     new int[]{ 0,0,0,0,0,0,0,0,0,0,0,0 } );
        put( "Pentahex1", new int[]{ 0,0,0,50,50,50,25,25,50,0,0,0 } );
        put( "Pentahex2", new int[]{ 100,100,100,150,150,150,125,125,150,100,100,100 } );
        put( "Pentahex3", new int[]{ 10, 30, 45, 400, 60, 75, 90, 80, 90, 500, 310, 120 } );

    }};

    private Myclass my = new Myclass();

    public static void main( String args[] ) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                new Iframe().setVisible( true );
            }
        });
    }

    public Iframe() {

        JPanel jp0 = new JPanel( new GridLayout() );
        JPanel jp1 = new JPanel( new GridLayout( 1, 3 ) );
        JPanel jp2 = new JPanel( new BorderLayout() );

        for( Entry<String, int[]> entry : pentahexMap.entrySet() ) {
            JButton pentahexbutton1;
            try {
                URL imgUrl                = new URL(PATH + entry.getKey() +".jpg");
                ImageIcon pentaheximg1    = new ImageIcon( imgUrl );
                pentahexbutton1           = new JButton( pentaheximg1 );
            } catch( MalformedURLException e ) {
                pentahexbutton1 = new JButton( entry.getKey() );
            }
            pentahexbutton1.addActionListener( this );
            pentahexbutton1.setName( entry.getKey() );
            jp1.add( pentahexbutton1 );
        }

        jp1.setBorder( BorderFactory.createTitledBorder( "Pentahexes" ) );
        jp2.setBorder( BorderFactory.createTitledBorder( "Puzzle" ) );

        jp0.add( jp1 );
        jp0.add( jp2 );
        jp2.add( my );
        this.add( jp0 );
        this.add( jp2 );
        this.add( jp1, BorderLayout.EAST );
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        int[] data = pentahexMap.get( ((JButton)e.getSource()).getName() );
        if(data != null) {
            my.setData( data );
            my.invalidate();
            my.repaint();
        }
    }
}

class Myclass extends JPanel {
    int a, b, c, d, e, f, g, h, i, j, k, l;
    Myclass(){}
    Myclass( int... data ) {
        setData( data );
    }
    public void setData( int... data ) {
        if(data.length < 12) {
            throw new IllegalArgumentException("not enough data");
        }
        a = data[0];
        b = data[1];
        c = data[2];
        d = data[3];
        e = data[4];
        f = data[5];
        g = data[6];
        h = data[7];
        i = data[8];
        j = data[9];
        k = data[10];
        l = data[11];
    }
    @Override
    public void paintComponent( Graphics graphics ) {
        super.paintComponent( graphics );
        int[] xcoordinatesofthehexagon = new int[] { a, c, e, g, i, k };
        int[] ycoordinatesofthehexagon = new int[] { b, d, f, h, j, l };
        if(!isEmpty(xcoordinatesofthehexagon, ycoordinatesofthehexagon)){
            graphics.drawPolygon( xcoordinatesofthehexagon, ycoordinatesofthehexagon, 6 );
        }
    }
    private boolean isEmpty(int[] x,int[] y) {
        for( int i : y ) {
            if(i != 0) {
                return false;
            }
        }
        for( int i : x ) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}