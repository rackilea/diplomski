Item searched = store.find(key);

if (searched != null)
   searched.print();
else 
   System.out.printf("No Item    found for %d%n", key);