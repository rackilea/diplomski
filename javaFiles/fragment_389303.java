Class clazz = Class.forName(yourClassName);
// either (for public methods)
Method method = clazz.getMethod(yourMethodName);
// or for protected / private methods:
Method method = clazz.getDeclaredMethod(yourMethodName, yourArgumentTypes);
method.setAccessible(true); 

// assuming the method is static
Object result = method.invoke(null, yourMethodArgs);
// otherwise: pass a object reference instead of null
// to call the method "on" that object