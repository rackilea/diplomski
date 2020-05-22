Iterator<String>  iter = players.iterator();
 while(iter.hasNext()){
   if(iter.next().equals(name)){
    iter.remove();
    break;
  }
}