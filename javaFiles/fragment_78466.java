public class BottomPanel extends JPanel implements ActionListener
{
    public JButton b1;

    /** added member to topPanel **/
    private JPanel mTopPanel;

    public BottomPanel(final JPanel topPanel)
    {
        super();
        setBackground(Color.pink);

        this.mTopPanel = topPanel;

        b1 = new JButton("When the user clicks on the button in the UPPER             
        panel, displays the football player's position here" );

        add(b1);

        /** the topPanel jli button listener **/
        this.mTopPanel.jl1.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 /** edit your button with the info of the player **/
                 b1.setText("player info added here");
             }
        });
    }

    public void actionPerformed(ActionEvent event)
    {
        Object obj = event.getSource();
        if(obj == b1)
        {
            b1.setText(fp1.getPosition());
        }
    }
}