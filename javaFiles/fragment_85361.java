HashMap<Object,String> map = new HashMap<>();

 for (Field f : Foo.class.getDeclaredFields()) {
     try {
     int modifiers = field.getModifiers();//check if the field is public and static
     if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
         if (f.get(null) != null) {
             map.put(f.get(null),f.getName());
         }
     } catch (Throwable t) {
     }
 }