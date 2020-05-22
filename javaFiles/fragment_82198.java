public int getScore() 
     if (value == Value.Ace)
       return 1;
     if (value == Value.Jack &&  value == Value.Queen && value == Value.King)
         return 10;

     return value.ordinal()+1;