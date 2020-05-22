public void actionPerformed(ActionEvent event) 
{
     String getStringChar = event.getActionCommand();
     char c = getStringChar.charAt(0);

     int arrayLength = Game.labelArray.length;

     for(int i = 0; i < arrayLength; i++)
     {
         if(Game.labelArray[i].getText().contains(""+ c))
         {
             Game.labelArray[i].setVisible(true);
         }      
     }

     if(!(Game.labelArray[arrayLength-1].getText().contains(""+ c)))
     {
         score++;
         Game.setImage(score);
     }
}// end method actionPerformed