List<Object> result = (List<Object>) LoadSource.list(); 
Iterator itr = result.iterator();
while(itr.hasNext()){
   Object[] obj = (Object[]) itr.next();
   //now you have one array of Object for each row
   String client = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String 
   Integer service = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
   //same way for all obj[2], obj[3], obj[4]
}