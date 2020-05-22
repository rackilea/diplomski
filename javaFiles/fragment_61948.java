Object a = new Object();
 Object b = new Object();
 System.out.println(a.hashCode());
 System.out.println(b.hashCode());
 System.out.println(System.identityHashCode(a));
 System.out.println(System.identityHashCode(b));