while(computerIsFrozen==false)
   {
      while(computerIsTagger==true)
      {
         if(nextToARobot)
         {
         playerIsFrozen = true;
         computerIsTagger = false;
      
      }
   }  // <-- remove this curly brace
   
   
   if(computerIsFrozen==true)
   {
      for(int k=1; k<=8; k++)
      {
      turnLeft();
      }
   computerIsTagger = true;
   computerIsFrozen = false;
   }
} 
​