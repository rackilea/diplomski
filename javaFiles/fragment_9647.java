public class Gotch {
    public static void main( String[] args ) {
        JFrame main = new JFrame();
        JPanel p = new JPanel();
        p.setLayout( new BorderLayout() );
        p.add( new JLabel( "test" ), BorderLayout.WEST );
        p.add( new JTextField( "growable" ), BorderLayout.CENTER );
        p.add( new JComboBox(), BorderLayout.EAST );
        main.add( p );
        main.pack();
        main.setVisible( true );
    }
}