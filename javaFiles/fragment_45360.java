public Object toArray(Class<?> componentType, int size, Parser p) {
   Object array = Array.newInstance(componentType, size);
   for (int i = 0; i < size; i++) 
      Arrays.set(array, i, p.nextItem());
   return array;
}