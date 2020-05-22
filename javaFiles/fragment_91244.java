import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class Iframe extends JFrame implements ActionListener {
    public JPanel jp0 = new JPanel( new GridLayout() );
    public JPanel jp1 = new JPanel( new GridLayout( 1, 3 ) );
    public JPanel jp2 = new JPanel( new BorderLayout() );
    Myclass       my  = new Myclass( 100, 200, 300, 400, 500, 600, 700, 900, 800, 10000, 3000, 600 );

    public static void main( String args[] ) {
        new Iframe();
    }

    public Iframe() {
        Border border = BorderFactory.createTitledBorder( "Pentahexes" );
        jp1.setBorder( border );

        ImageIcon Pentaheximg1 = new ImageIcon( "E:/NetBeans/Pentahex-Game/src/pentahex/game/Pentahex1.jpg", "b1" );
        JButton Pentahexbutton1 = new JButton( Pentaheximg1 );
        Pentahexbutton1.addActionListener( this );
        Pentahexbutton1.setName( "b1" );
        jp1.add( Pentahexbutton1 );

        ImageIcon Pentaheximg2 = new ImageIcon( "E:/NetBeans/Pentahex-Game/src/pentahex/game/Pentahex2.jpg", "b1" );
        JButton Pentahexbutton2 = new JButton( Pentaheximg2 );
        Pentahexbutton2.addActionListener( this );
        Pentahexbutton2.setName( "b2" );
        jp1.add( Pentahexbutton2 );

        ImageIcon Pentaheximg3 = new ImageIcon( "E:/NetBeans/Pentahex-Game/src/pentahex/game/Pentahex3.jpg", "b1" );
        JButton Pentahexbutton3 = new JButton( Pentaheximg3 );
        Pentahexbutton3.addActionListener( this );
        Pentahexbutton3.setName( "b3" );
        jp1.add( Pentahexbutton3 );

        Border border2 = BorderFactory.createTitledBorder( "Puzzle" );
        jp2.setBorder( border2 );

        jp0.add( jp1 );
        jp0.add( jp2 );
        jp2.add( my );
        this.add( jp0 );
        this.add( jp2 );
        this.add( jp1, BorderLayout.EAST );
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if( "b1".equals( ((JButton)e.getSource()).getName() ) ) {
            my.setData( 100, 200, 300, 400, 500, 600, 700, 900, 800, 10000, 3000, 600 );
        }
        if( "b2".equals( ((JButton)e.getSource()).getName() ) ) {
            my.setData( 10, 20, 30, 400, 50, 60, 70, 80, 90, 100, 110, 120 );
        }
        if( "b3".equals( ((JButton)e.getSource()).getName() ) ) {
            my.setData( 10, 30, 45, 400, 60, 75, 90, 80, 90, 1000, 3010, 120 );
        }
        my.drawpoly();
    }
}

class Myclass extends JPanel {
    int a, b, c, d, e, f, g1, h, i, j, k, l;

    Myclass( int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6 ) {
        setData( x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6 );
    }

    public void setData( int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6 ) {
        a = x1;
        b = y1;

        c = x2;
        d = y2;

        e = x3;
        f = y3;

        g1 = x4;
        h = y4;

        i = x5;
        j = y5;

        k = x6;
        l = y6;
    }

    public void drawpoly() {
        invalidate();
        repaint();
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        int xcoordinatesofthehexagon[] = new int[] { a, c, e, g1, i, k };
        int ycoordinatesofthehexagon[] = new int[] { b, d, f, h, j, l };
        g.drawPolygon( xcoordinatesofthehexagon, ycoordinatesofthehexagon, 6 );
    }
}