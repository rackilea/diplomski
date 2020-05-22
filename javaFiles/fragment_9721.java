class PageScreen2 extends JPanel {
    private PageScreen2() {
        setLayout( null );
        JLabel label1 = new JLabel( "LOG:" );
        label1.setBounds( 10, 15, 150, 20 );
        add( label1 );

        JLabel label2 = new JLabel( "Well 1 PMW Pressure Sensor - Tag xx123" );
        label2.setBounds( 10, 45, 300, 20 );
        add( label2 );
    }
}