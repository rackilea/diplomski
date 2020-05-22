public class IntroPanel extends JPanel {

private int x = 300;
private JButton exitButton, startButton;
private JPanel buttonsPanel;

public IntroPanel()
{
    setPreferredSize( new Dimension( 300, 150));
    setLayout( new BorderLayout());

    buttonsPanel = new JPanel();
    exitButton = new JButton( "Exit" );
    startButton = new JButton( "Start" );

    exitButton.addActionListener( new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    startButton.addActionListener( new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * TODO GOES TO MAIN PANEL
             */
        }
    });

    setBackground( new Color( 250, 250, 250) );
    startButton.setPreferredSize( new Dimension(70, 40) );
    exitButton.setPreferredSize( new Dimension(70, 40) );
    Border padding = BorderFactory.createEmptyBorder(0, 0, 25, 0);
    setBorder(padding);
    buttonsPanel.setBackground( new Color( 250, 250, 250));
    buttonsPanel.add(startButton);
    buttonsPanel.add(exitButton);
    add(buttonsPanel, BorderLayout.SOUTH);
}

public void animate()
{
    super.paintComponent(page);
    for( int i = 1; i < 211; i++ )
    {
        x--;

        repaint();

        try
        {
            Thread.sleep(10);
        }
        catch(InterruptedException ex) { }
    }
}

public void paintComponent( Graphics page )
{
    Graphics2D gra = (Graphics2D) page;

    gra.setFont( new Font( "Philosopher-BoldItalic", Font.ITALIC | Font.BOLD, 50 ) );

    Color start = new Color( 50, 50, 50 );
    Color end = new Color( 250, 250, 250 );

    GradientPaint gradient = 
            new GradientPaint( 120, 100, start, 270, 270, end);

    gra.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, 
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    gra.setPaint( gradient );

    gra.drawString("Geometrica", x, 100);
 }
}