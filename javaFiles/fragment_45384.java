public void actionPerformed(ActionEvent event) 
{
     String getStringChar = event.getActionCommand();
     char c = getStringChar.charAt(0);

     int arrayLength = Game.labelArray.length;

     containsCharacter = false
     for(int i = 0; i < arrayLength; i++)
     {

         if(Game.labelArray[i].getText().contains(""+ c))
         {
             Game.labelArray[i].setVisible(true);
             containsCharacter = true
         }      
     }

     if(!containsCharacter)
     {
         score++;
         Game.setImage(score);
     }
}// end method actionPerformed