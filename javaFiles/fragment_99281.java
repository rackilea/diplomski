public static void main (String[] args) throws Exception
   {
      int bet = getBet(),  winnings;

      do
      {
         TripleString thePull = pull();
         getPayMultiplier(thePull);
         winnings = getPayMultiplier(thePull) * bet;
         display(thePull, winnings);
         bet = getBet();
      }
      while ( bet != 0);

      System.out.println("Thanks");
    }