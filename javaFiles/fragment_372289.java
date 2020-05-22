public Item findItem(String name)
{
   for(Item item : arrayListItems){
      if(item.getName().equals(name){
         return item;
      }
   }
   return null;
}