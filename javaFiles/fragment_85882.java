ArrayList<String> classes = ClassesRetrieval.getYagoClasses();
  Iterator<String> it = classes.iterator();
   while(it.hasNext()){
     if(!it.next().contains("yago")){
         it.remove();
     }
  }
  for(String i : classes){
      System.out.println(i);
  }