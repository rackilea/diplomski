if(!results.isEmpty()) {    
   int index = 0;       
   int size = results.size();
   for(;index < size;++index) {
   list.add(btn = new 
   MultiButton(results.get(index).getString("Title")));
   addListener(btn);
}