for(ListIterator it=array_test.listIterator();it.hasNext();){ 
 String link=it.next(); 
   it.add("r");
   it.previous();
   it.add("kk");
   it.previous();
System.out.println(link);  
}