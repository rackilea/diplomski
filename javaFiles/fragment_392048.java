Object x = 0;
Object y = 0;
System.out.println(x == y); // Guaranteed to be true

Object x = 10000;
Object y = 10000;
System.out.println(x == y); // *May* be true