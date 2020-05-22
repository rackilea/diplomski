while (listIterator.hasNext()){
   // iterate always
   item = listIterator.next();
   // if found and an element still exist
   if(item.getCode().equals(search.getCurrentCode() && listIterator.hasNext()){
      // get the next element
      item = listIterator.next();
      result.setCurrentCode(item.getCode());
      break;
   }
}