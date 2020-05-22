int getItemIndex(String nameOfItem){
   for(int i = 0; i < itemList.length; i++){
      if(itemList[i].getName().equals(nameOfItem){
         return i;
      }
   }
   return -1;
}