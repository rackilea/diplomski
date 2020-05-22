Field[] fields=UUIDd.class.getDeclaredFields(); // get all declared fields 
for(Field field:fields){
   if(field.getType().equals(String.class)){ // if it is a String field
     System.out.println(field.getName());
   }
}