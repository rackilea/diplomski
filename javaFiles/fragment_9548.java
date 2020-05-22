Class<?> clazz = Class.forName("Book");
// Object obj1 = clazz.cast(obj);
// The method getName() is undefined for the type Object

Method m = clazz.getMethod("getName");
String res = (String) m.invoke(obj);