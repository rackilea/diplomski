import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "TestFrame" );

        CardLayout cardLayout = new CardLayout();
        JPanel contentPane = new JPanel( cardLayout );

        JPanel firstPanel = new JPanel(  );
        firstPanel.setLayout( new BorderLayout(  ) );
        firstPanel.add( new JLabel( "Contents" ) );

        //wrap the smallest panel instead of directly adding it
        contentPane.add( firstPanel, "first" );
//        JPanel wrappedPanel = new JPanel( new BorderLayout(  ) );
//        wrappedPanel.add( firstPanel, BorderLayout.NORTH );
//        contentPane.add( wrappedPanel, "first" );

        JPanel secondPanel = new JPanel( new BorderLayout(  ) );
        secondPanel.add( new JComponent() {
          @Override
          public Dimension getPreferredSize() {
            return new Dimension( 500, 500 );
          }
        }, BorderLayout.CENTER );
        contentPane.add( secondPanel, "second" );

        cardLayout.show( contentPane, "first" );

        frame.setContentPane( contentPane );
        frame.pack();
        frame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        frame.setVisible( true );
      }
    } );
  }
}