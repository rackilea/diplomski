public static void propertyHack(Object bean, String property, String nullreplace){
  try{
    return new BeanUtilsBean().getProperty(bean, property);
  }
  catch(NullPointerException npe){
    return nullreplace;
  }
}