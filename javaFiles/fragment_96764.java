public class Game
{
    private JPanel  Game;
    private JButton Water;
    private JButton Nature;
    private JButton Fire;
    private int         myChoice;
    private int         computerChoice;
    int                         gamePlayed  = 0;    //store the times of game played

    public Game()
    {
        JFrame frame = new JFrame( "The Elements" );
        frame.setContentPane( this.Game );
        frame.setMinimumSize( new Dimension( 500, 500 ) );
        frame.pack();
        frame.setVisible( true );

        Water.addActionListener( new ActionListener()
        {
            @Override
            //Water counter Fire , Nature counter water
            public void actionPerformed( ActionEvent e )
            {
                int select;
                select = JOptionPane.showConfirmDialog( null, "You're using the power of water", "Water", JOptionPane.YES_NO_OPTION );

                if ( select == JOptionPane.YES_OPTION )
                {
                    myChoice = 0;
                    computerChoice = computerPlays();
                    conditionsDisplayResults( myChoice, computerChoice );
                    gamePlayed += 1;//add 1 time of played game when the yes option clicked

                }

                if ( this.gamePlayed > 5 )
                {
                    exit();
                }
            }
        } );
        Fire.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                int select = JOptionPane.showConfirmDialog( null, "You're using the power of fire", "Fire", JOptionPane.YES_NO_OPTION );

                if ( select == JOptionPane.YES_OPTION )
                {
                    myChoice = 1;
                    computerChoice = computerPlays();

                    conditionsDisplayResults( myChoice, computerChoice );
                    gamePlayed += 1;//add 1 time of played game when the yes option clicked
                }

                if ( this.gamePlayed > 5 )
                {
                    exit();
                }
            }
        } );
        Nature.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                int select = JOptionPane.showConfirmDialog( null, "You're using the power of nature", "Nature", JOptionPane.YES_NO_OPTION );

                if ( select == JOptionPane.YES_OPTION )
                {
                    myChoice = 2;
                    computerChoice = computerPlays();
                    conditionsDisplayResults( myChoice, computerChoice );
                    gamePlayed += 1;//add 1 time of played game when the yes option clicked
                }

                if ( this.gamePlayed > 5 )
                {
                    exit();
                }
            }
        } );
    }

    void exit()
    {
        // exit code
    }
}