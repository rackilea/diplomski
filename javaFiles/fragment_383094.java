Iterator<Object> it = objects.iterator();
while(it.hasNext()){
    Object node = someFunction(session,it);
}

public Object someFunction(Session session,Iterator i){
   //manipulate i value based on condition
   if(true){
      i.next();
   }else{
      i.next();
      i.next();
   }
}