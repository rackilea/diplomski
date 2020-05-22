Object bytePrimitive = (byte) 10;

System.out.println("is a Byte ?   " + (bytePrimitive instanceof Byte));
System.out.println("Check class = " + (bytePrimitive.getClass()));

// false because class in this case becomes Byte, not byte.
System.out.println("Primitive = " + (bytePrimitive .getClass().isPrimitive()));