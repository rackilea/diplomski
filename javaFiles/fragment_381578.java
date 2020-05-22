JButton button = new JButton("Text Button");
button.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
    //Call the methods for the calculation
    // bmr and tdee are temporary variables to store the results from the methods
    //handle them properly, or remove them if not needed (I just wrote a sample)
    int bmr = calcBMR(...); //pass the correct variables as arguments here
    int tdee;
    if(userHasPickedTDEE) {  tdee = calcTDEE(...); }  //and here
    label.setText(....);

  }
});