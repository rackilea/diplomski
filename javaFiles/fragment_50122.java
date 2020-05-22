Boolean bool1 = new Boolean(true);
Boolean bool2 = Boolean.TRUE;
Boolean bool3 = true;

System.out.println(System.identityHashCode(bool1));
System.out.println(System.identityHashCode(bool2));
System.out.println(System.identityHashCode(bool3));