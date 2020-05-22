public ArrayList<Item> getItemByType(String type){
   ArrayItem<Item> arrayListFilteredItems = new ArrayList<>();

   for(Item item : arrayListItems){
      if(item.getType().equals(type){
         arrayListFilteredItems.add(item);
      }
   }

   return arrayListFilteredItems;
}