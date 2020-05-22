Iterator<String> it= newStr.iterator();
while(it.hasNext()) { // iterate
   String word = it.next();
   if(word.length() == 5) { // predicate
      it.remove();  // remove from set through iterator - action
   }
}