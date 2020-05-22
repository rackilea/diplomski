Machine[] findAll(String[] names){
     ArrayList<Machine> machines =new ArrayList<ArrayList>();
      for(String s:names){
         Machine m  = find(s); 
         if(m!=null){
             machines.add(m);
         }
     }
     return machines.toArray(new Machine[0])
}