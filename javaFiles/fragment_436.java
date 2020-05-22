for(int suit = 0; suit <= 3; suit++)
{
   for(int value = 0; value <= 12; value++)
   {
      deck.add(new Card(value, suit)); 
      index++;
   }   
}