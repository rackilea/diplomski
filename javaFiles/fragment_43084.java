UUIDd uuiDd=new UUIDd();
Field[] fields= uuiDd.getClass().getDeclaredFields(); // get all declared fields
for(Field field:fields){
   if(field.getType().equals(String.class)){ // if it is a String field
      System.out.println("Variable name: "+field.getName());
      field.setAccessible(true);
      System.out.println("Variable value: "+field.get(uuiDd));
    }
}