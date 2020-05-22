public void actionPerformed(ActionEvent e)
{

    if(e.getSource() == red)
    {
            messageBottom += "R";
            //System.out.println("R");
    }
    else if (e.getSource()==blue)
    {
         messageBottom += "B";
         //System.out.println ("B");
    }
    else if (e.getSource()==yellow)
    {
        messageBottom += "Y";
        //System.out.println ("Y");
    }
    else if (e.getSource()==green)
    {
        messageBottom += "G";
        //System.out.println ("G");
    }

    labelBottom.setText (messageBottom);
}