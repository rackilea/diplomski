public class MultiPagesCardLayout extends JPanel implements ActionListener {

   MultiPagesCardLayout() {
      super( new BorderLayout());
      add( _leftBtn , BorderLayout.WEST   );
      add( _pages   , BorderLayout.CENTER );
      add( _rightBtn, BorderLayout.EAST   );
      _leftBtn .addActionListener( this );
      _rightBtn.addActionListener( this );
      _animation.setInitialDelay( 10 );
      _animation.setRepeats( false );
   }

   public void addPage( Component page ) {
      _pages.add( page, "" + ( _pages.getComponentCount() - 1 ));
   }

   @Override
   public void actionPerformed( ActionEvent e ) {
      Object src = e.getSource();
      if( src == _leftBtn ) {
         ((CardLayout)_pages.getLayout()).previous( _pages );
      }
      else if( src == _rightBtn ) {
         ((CardLayout)_pages.getLayout()).next( _pages );
      }
   }

   private final JPanel  _pages     = new JPanel( new CardLayout());
   private final JButton _leftBtn   = new JButton( "<<" );
   private final JButton _rightBtn  = new JButton( ">>" );
   private final Timer   _animation = new Timer( 0, this );

   public static void main( String[] args ) {
      SwingUtilities.invokeLater( new Runnable() {
         @Override public void run() {
            JFrame frame = new JFrame( "Multi pages demo App" );
            frame.setLayout( new BorderLayout());
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            MultiPagesCardLayout multiPage = new MultiPagesCardLayout();
            multiPage.setPreferredSize( new Dimension( 250, 100 ));
            JPanel page;
            page = new JPanel();
            page.setBackground( Color.CYAN );
            page.setLayout( new BorderLayout());
            page.add( new JLabel( "First page", SwingConstants.CENTER ), BorderLayout.CENTER );
            multiPage.addPage( page );
            page = new JPanel();
            page.setBackground( Color.YELLOW );
            page.setLayout( new BorderLayout());
            page.add( new JLabel( "Second page", SwingConstants.CENTER ), BorderLayout.CENTER );
            multiPage.addPage( page );
            page = new JPanel();
            page.setBackground( Color.GREEN );
            page.setLayout( new BorderLayout());
            page.add( new JLabel( "Third page", SwingConstants.CENTER ), BorderLayout.CENTER );
            multiPage.addPage( page );
            page = new JPanel();
            page.setBackground( Color.RED );
            page.setLayout( new BorderLayout());
            page.add( new JLabel( "Fourth page", SwingConstants.CENTER ), BorderLayout.CENTER );
            multiPage.addPage( page );
            frame.add( multiPage, BorderLayout.CENTER );
            frame.pack();
            frame.setLocationRelativeTo( null );
            frame.setVisible( true );
         }});
   }
}