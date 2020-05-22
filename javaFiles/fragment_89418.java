Thing t1 =  new Thing(), t2 = new Thing();
System.out.println(t1.equals(t2)); // true, great
Object o1 = t1, o2 = t2;
System.out.println(o1.equals(o2)); // now suddenly false
System.out.println(t1.equals(o2)); // false again
System.out.println(o1.equals(t2)); // still false