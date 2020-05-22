private class Listener implements ActionListener   
{
  //counter to dynamically change numeric text values 
  //as well as to mark progress through colorSequence
  int count = 1; 
  public void actionPerformed(ActionEvent e)
  {
    if (count < colorSequence.length)
    {
      if (colorEntry.getText().equals(colorSequence[count - 1]))
      {
        count++;
        colorEntry.setText("");
        colorPrompt.setText("Enter color number: " + count);
      }
      else
      {
        colorEntry.setVisible(false);
        colorPrompt.setText("Sorry - wrong answer. Eat more antioxidants.");
      }
    } //end if (for while the program is still iterating through the array)
    else
    {
      colorPrompt.setText("Congratulations - your memory is perfect");
      colorEntry.setVisible(false);
    } //end else (the user has properly stepped through all the colors in the array)
  } //end actionPerformed   
} //end private class Listener