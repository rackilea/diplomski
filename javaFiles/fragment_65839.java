CharBuffer cb1 = CharBuffer.allocate(10);
cb1.put('a'); // increments position
cb1.put('b'); // increments position

CharBuffer cb2 = CharBuffer.allocate(8);

System.out.println(cb1.equals(cb2)); // true, 00000000 equals 00000000