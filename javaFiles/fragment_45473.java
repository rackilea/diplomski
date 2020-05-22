actionPerformed(ActionEvent);
{
    objButton1.addActionListener(this);
    objButton2.addActionListener(this);
    if(e.getSource()==objButton1)
    {
        numClicks++;
    }
    else
    {
        numClicks2++;
    }
    count.setText("There are " + numClicks + " who agree");
    count2.setText("There are " + numClicks2 + " who dissagree");
}