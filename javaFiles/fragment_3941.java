public GameWords ()
{
     setTitle ( " Word Order Game " ) ;
     setLayout ( new FlowLayout() ) ;
     setDefaultCloseOperation ( EXIT_ON_CLOSE ) ;
     createContent () ;
     pack();
     setVisible ( true ) ;
}

public void createContent ()
{
    JLabel heading = new JLabel (" Fun With Words ") ;
    heading.setFont ( heading.getFont().deriveFont ( 26f ) );
    JLabel h1 = new JLabel ( " Hey Kids! Want to prictice your typing and word-ordering Skills ? \n" ) ;
    add ( heading ) ;
    add ( h1 ) ;


}