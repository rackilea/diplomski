class PageScreen3 extends JPanel {

    private PageScreen3() {
        setLayout( null );
        JLabel label1 = new JLabel( "GENERAL SETTINGS:" );
        label1.setBounds( 10, 15, 150, 20 );
        add( label1 );

        JLabel label2 = new JLabel( "Tag Name:" );
        label2.setBounds( 10, 45, 300, 20 );
        add( label2 );

        JTextField jtext1 = new JTextField( "Tag xx123" );
        jtext1.setBounds(95, 45, 100, 20);
        add( jtext1 );

        JLabel label3 = new JLabel( "Description:" );
        label3.setBounds( 10, 65, 300, 20 );
        add( label3 );

        JTextField jtext2 = new JTextField( "Tag1" );
        jtext2.setBounds(95, 65, 100, 20);
        add( jtext2 );   
    }
}