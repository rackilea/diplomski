static class JaxbUtil {
  static <T> T copy(Class<T> cls, T obj) throws InstantiationException, IllegalAccessException{
    T copy = cls.newInstance();
    for(Field f:cls.getDeclaredFields()){
      XmlElement annotation = f.getAnnotation(XmlElement.class);
      if(annotation != null && annotation.required()){
        f.setAccessible(true);
        f.set(copy, f.get(obj));
      }
    }
    return copy;
  }
}