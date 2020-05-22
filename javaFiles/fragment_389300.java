Class partypes[] = new Class[0];
Object arglist[] = new Object[0];
Method getContextMethod = ClassA.class.getDeclaredMethod("getFieldX",partypes);

getContextMethod.setAccessible(true);

String retValue =  (string) getContextMethod.invoke(classCInstance, arglist);