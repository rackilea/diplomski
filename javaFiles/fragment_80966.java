String str;

Object obj = (Object)rs.getObject(1);

if(obj instanceof String){
   //do you work here for string like below
     str=(String)obj;
}
else if (obj instanceof Integer){
   //do your work for Integer
}