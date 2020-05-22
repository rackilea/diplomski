Iterator it=row.entrySet().iterator();  
Iterator iter=getPrimaryKey.entrySet().iterator();

 while(it.hasNext()){
    Map.Entry pairs=(Map.Entry)it.next();
    if(! getPrimaryKey.keySet().contains(pairs.getKey()){ 
    }