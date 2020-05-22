for (String s : cpr){
 Iterator<String> itr= cmp.iterator();
  while (itr.hasNext()){
   String t = itr.next();
     if (s.equals(t)){
        itr.remove();
    }
  }
}