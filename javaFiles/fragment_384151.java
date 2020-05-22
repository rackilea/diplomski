public void add(Item item){
   if (!item.isBulk()){
      weight += item.getWeight();
   }
   else{
       bulk = item.isBulk(); // as discussed check the relevance of this flag.
   }
   // ...
}