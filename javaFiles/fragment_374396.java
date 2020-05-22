public Map<Object, String> populateMap(final Object o) throws Exception {
  Map<Object, String> result = new HashMap<>();
  for (PropertyDescriptor pd : Introspector.getBeanInfo(o.getClass()).getPropertyDescriptors()) {
    String fieldName = pd.getName();
    if("class".equals(fieldName) continue;
    Object value = pd.getReadMethod().invoke(o);
    result.put(value, fieldName);
  }
  return result;
}