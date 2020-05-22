public int numOfBeepersInPile()
 {
     if (nextToBeeper())
     {
        pickBeeper();
        return 1 + numOfBeepersInPile();
     }
     return 0;
 }