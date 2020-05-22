protected JavaType getJavaType(Class<?> clazz) {
   if (List.class.isAssignableFrom(clazz)) {
     return TypeFactory.collectionType(ArrayList.class, MyBean.class);
   } else {
     return super.getJavaType(clazz);
   }
}