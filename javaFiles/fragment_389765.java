Class cls = R.drawable.class;
Field fieldlist[] = cls.getDeclaredFields();
for (Field fld : fieldlist) {
   String fieldName = fld.getName();
   if (fieldName.startsWith("PREFIX_") {
     int drawableId = fld.getInt(null);
     // do whatever with the drawable
   }
}