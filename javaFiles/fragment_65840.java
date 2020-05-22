CharBuffer cb1 = CharBuffer.allocate(10);
cb1.put((char) 0);
cb1.put((char) 0);
cb1.put((char) 0);
cb1.put((char) 0);
cb1.put('a');
cb1.put('b');
// put(char) increments position so we need to rewind
cb1.rewind(); 

CharBuffer cb2 = CharBuffer.allocate(10);
cb2.put(4, 'a');
cb2.put(5, 'b');

System.out.println(cb1.equals(cb2)); // true, 0000ab0000 equals 0000ab0000