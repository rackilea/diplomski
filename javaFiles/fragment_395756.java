while(iterate.hasNext()){
   String str = iterate.next();
   if(str.equalsIgnoreCase("Dog")){
       iterate.remove();
       lst.add(0, str);
   }
}