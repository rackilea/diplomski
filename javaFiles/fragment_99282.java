public static void main (String[] args) throws Exception
   {
      int  winnings;
      int  bet;
      while ((bet = getBet()) != 0)
      {
         TripleString thePull = pull();
         getPayMultiplier(thePull);
         winnings = getPayMultiplier(thePull) * bet;
         display(thePull, winnings);
      }
      System.out.println("Thanks");
   }