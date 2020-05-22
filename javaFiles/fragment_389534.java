Class<?> objClass = o.getClass();
Field[] fields = objClass.getDeclaredFields();
List<Field> fieldList = new LinkedList<Field>();
for(Field field : fields) { 
    field.setAccessible(true);
    Object value = field.get(o);
    if(value instanceof String)
        if(((String) value).length() > 10){
            fieldList.add(field);
        }               
  }
 }
 return fieldList;