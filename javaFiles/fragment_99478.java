public class TestJpanel extends JFrame {


    public TestJpanel() {
        this.setLayout( new BorderLayout() );

        final JLabel card1 = new JLabel( "card1" );
        final JLabel card2 = new JLabel( "card2" );

        final JPanel topPanel = new JPanel();
        topPanel.setPreferredSize( new Dimension( 1024, 100 ) );
        topPanel.add( card1 );
        topPanel.add( card2 );

        this.add( topPanel, BorderLayout.NORTH );

        JPanel centerPanel = new JPanel();
        final JButton hideCardsButton = new JButton( "Hide cards" );
        hideCardsButton.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e ) {
                if ( topPanel.getComponentCount() == 0 ) {
                    topPanel.add( card1 );
                    topPanel.add( card2 );
                    hideCardsButton.setText( "Hide cards" );
                } else {
                    topPanel.removeAll();
                    hideCardsButton.setText( "Show cards" );
                }
                topPanel.validate();
                topPanel.repaint();
            }
        } );
        centerPanel.add( hideCardsButton );

        this.add( centerPanel, BorderLayout.CENTER );
    }

    public static void main( String[] args ) {
        TestJpanel window = new TestJpanel();
        window.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        window.setSize( 1024, 768 );
        window.setVisible( true );
    }

}