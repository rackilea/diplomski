Class[] parameterTypes = new Class[] { String.class, Integer[].class };

//System.out.println(Arrays.toString(parameterTypes));
ReflectionTest test = new ReflectionTest();
Method varMeth = test.getClass().getDeclaredMethod("varargMethod", 
                                                      parameterTypes);
System.out.println("varMeth" + varMeth);

Object[] arguments = new Object[] { new String("my perfect string"),
                                    new Integer[]{10, 100, 47}
                                  };

varMeth.invoke(test, arguments);