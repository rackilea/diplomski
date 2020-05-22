Method method = Person.class.getMethod("get"+ filter, null);

String returnValue = (String)(method.invoke(p, null));

if(isIn(returnValue , values))
...