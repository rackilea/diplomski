synchronized(arrayList) {
    Iterator it=arrayList.iterator(); 
    while(it.hasNext()) { 
        System.out.println(it.next()); 
   } 
}