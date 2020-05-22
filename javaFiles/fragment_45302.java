Object obj = new Object();

IntSupplier foo = obj::hashCode;
IntSupplier bar = obj::hashCode;

System.out.println(foo == bar);  // false

System.out.println(foo.equals(bar));  // false