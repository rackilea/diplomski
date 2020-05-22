Method[] methods = myObject.getClass().getMethods();
for (Method method : methods) {
  if (!method.getName().equals("methodtobeinvoked")) continue;
  Class[] methodParameters = method.getParameterTypes();
  if (methodParameters.length!=1) continue; // ignore methods with wrong number of arguments
  if (methodParameters[0].isAssignableFrom(myArgument.class)) {
    method.invoke(myObject, myArgument);
  }
}