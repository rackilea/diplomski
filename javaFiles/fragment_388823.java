import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frm
   extends
      JFrame
   implements
      ActionListener
{
   Frm()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setPreferredSize( new Dimension( 640, 480 ));
      setLayout( new BorderLayout());
      JButton getScreenBtn = new JButton( "Get Screen ID" );
      add( getScreenBtn, BorderLayout.CENTER );
      getScreenBtn.addActionListener( this );
      pack();
      setLocationRelativeTo( null );
      setVisible( true );
   }

   @Override
   public void actionPerformed( ActionEvent e ) {
      setTitle( getGraphicsConfiguration().getDevice().getIDstring());
   }

   public static void main( String[] args ) {
      SwingUtilities.invokeLater( new Runnable() {
         @Override public void run() { new Frm(); }});
   }
}