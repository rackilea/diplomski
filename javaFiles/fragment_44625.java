ArrayList<Integer> list = new ArrayList<Integer>(); // add some values to it
ArrayList<Integer> del = new ArrayList<Integer>(); // Elements to be deleted

for(int i : list) { // ConcurrentModificationException
   Iterator iterator = list.iterator();
   while(iterator.hasNext()) {    
      int n = iterator.next();
      if(n % i == 0) {
          del.add(n);      
      }
   }
}

list.removeALL(del);