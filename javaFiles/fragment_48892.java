public boolean remove(Item i)
{
   //return false if item is not in the list, call equals method from item class
   for(Item current : items){
      if(current.equals(i)){
         items.remove(current);
         return true;
      } 
   }
   return false;
}