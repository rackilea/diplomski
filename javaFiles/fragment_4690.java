JAXBContext getContext(Class cls) {
  if (contexts.containsKey(cls)) return contexts.get(cls);
  JAXBContect context = JAXBContext.newInstance(cls);
  contexts.put(cls,context);
  return context;
}
...
JAXBContext jc =getContext(Bags.class);