jshell> class MyClass<N extends Number> {
   ...>     N n = (N) (new Integer(8));
   ...> }
|  Warning:
|  unchecked cast
|    required: N
|    found:    java.lang.Integer
|      N n = (N) (new Integer(8));
|                ^--------------^
|  created class MyClass

jshell> System.out.println(new MyClass<Long>().n);
8

jshell> System.out.println(new MyClass<Long>().n.getClass());
|  java.lang.ClassCastException thrown: java.base/java.lang.Integer cannot be cast to java.base/java.lang.Long
|        at (#4:1)