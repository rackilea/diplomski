Comparator<Class<?>> c=new Comparator<Class<?>>{
  @Override
  int compare(Class<?> a, Class<?> b) { 
     // your comparison logic 
  }
};

List<Class<?>> list= ...
Collections.sort(list, c);

Set<Class<?>> set=new TreeSet<>(c);