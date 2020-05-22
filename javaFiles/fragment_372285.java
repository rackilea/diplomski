static final String ENHANCER = "$$EnhancerByMockitoWithCGLIB$$";

 static Class<? extends Object> typeOf(Object instance) {
   Class<? extends Object> type = instance.getClass();
   while(type.getSimpleName().contains(ENHANCER)) {
     type = type.getSuperclass();
   }

   return type;
 }