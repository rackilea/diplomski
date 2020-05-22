synchonized (lock) {
   long id = selectMaxFromDatabase(id);
   id ++;
   if (id % 2 != 0) {
      id ++;
   }  
}