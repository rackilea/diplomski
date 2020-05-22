groovy:000> stringarray = ['a', 'b', 'c'] as String[]
===> [a, b, c]
groovy:000> stringarray.class
===> class [Ljava.lang.String;
groovy:000> stringarray.class.array
===> true
groovy:000> stringarray << 'd'
ERROR groovy.lang.MissingMethodException:
No signature of method: [Ljava.lang.String;.leftShift() is applicable 
for argument types: (java.lang.String) values: [d]
groovy:000> stringarray[0]
===> a