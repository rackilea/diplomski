import java.awt.*;
 import javax.swing.*;
 public class Grid extends JFrame {

 public Grid()    {       
 setSize( 500, 500 );
 setVisible( true );   
 } 
public void paint( Graphics g )    
 {  
 for ( int x = 30; x <= 300; x += 30 )
 for ( int y = 30; y <= 300; y += 30 ) 
 g.drawRect( x, y, 30, 30 );

 } 
 public static void main( String args[] ) 
 {
     Grid application = new Grid();
 application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   }  }