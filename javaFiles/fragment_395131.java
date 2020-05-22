String move()
   {

   if(y+1<n)//Can Move Up
   return "up";

   if(y-1>=0)//Can Move Down
   return "down";

   if(x+1<n)//Can Move Right
   return "right";

   if(x-1>=0)//Can Move Left
   return "left";

   return "can't move";

  }