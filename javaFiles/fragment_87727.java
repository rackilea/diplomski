boutonOK.addActionListener(new ecout5(Na));

...

class ecout5 implements ActionListener 
{   
    private int Na;
    public ecout5(int Na)
    {
        this.Na = Na;
    }

    public void actionPerformed(ActionEvent evt)
    {

        for(int i = 0;i < Na ;i++)
        {
            nbGrpGen[i] = allField[i].getText();
        }                   
    }