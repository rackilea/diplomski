final   ClassInfo classInfo = new ClassInfo(); 
  Field[] fields =   Demo.class.getFields(); 
 for(final field :fields) {
    FieldInfo fieldInfo = new FieldInfo(field);
    if(field.hasAnnotation(Id.class)) {
      fieldInfo.setId(true); 
   } 
    if(field.hasAnnotation(ColumnName.class){
     final ColumnName col = field.getAnnotation(ColumnName.class); 
     fieldInfo.setColumnName(col.value());
    }
 }