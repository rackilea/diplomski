boutonOK.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evt)
    {

        for(int i = 0;i < Na ;i++)
        {
            nbGrpGen[i] = allField[i].getText();
        }                   
    }
}