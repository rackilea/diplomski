List<?> myEntities = new LinkedList<?> {
   @Override 
   public boolean add(Object obj) {
       if (obj != null && obj.getClass().isAnnotationPresent(MyEntity.class)) {
           return super.add(obj);
       }
       throw new IllegalArgumentException("Only objects annotated with MyEntity are allowed");
   }

   @Override
   public boolean addAll(Collection<?> objs) {
      //something similar, maybe with Collections2.filter from Google Collections
   }
};