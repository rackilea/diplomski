private static void partialStateTransfer(Object copyFrom,Object copyTo) {
    //you can't update null or 0 value using this method 
  
  Field[] fields = copyFrom.getClass().getDeclaredFields();

  for (Field field : fields) {
   try {
    field.setAccessible(true);
    if ((field.get(copyFrom) != null) && !(field.get(copyFrom).equals(new Integer(0)))) {
     field.set(copyTo, field.get(copyFrom));
    }
   } catch (IllegalArgumentException | IllegalAccessException e) {
    e.printStackTrace();
   }

  }
 }