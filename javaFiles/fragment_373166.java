public <T> Key<?> bindMultibinder(
 Named annotation, Class<T> superClass, ArrayList<Class<? extends T>> contents) {
   Multibinder<T> options = 
    Multibinder.newSetBinder(binder(), superClass, annotation);
   for (Class<? extends T> t : contents) {
      options.addBinding().to(t);
   }
   final Key<?> multibinderKey = Key.get(Types.setOf( superClass ), annotation);
   return multibinderKey;
}