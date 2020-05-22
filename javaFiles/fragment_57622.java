Shape s = new Rectangle(); // Works fine
Rectangle r = (Rectangle)s; // Works fine
Rectangle r2 = s; // Needs typecasting, Compile fail
Rectangle[] rar = new Rectangle[1]; // Fine, array of length 1
s.setS1(3.0); // Shape doesn't know about setS1(), compile fail
s.computeArea(); // Works fine, though abstract method, known that an solid class has to implement
rar[0].computeArea(); // Run time NullPointerException, rar[0] not initialized
r.s1 = 4.5; // s1 is private, compile error
r.setS1(5.0); // works fine
r.setS2(3.0); // works fine
s.getArea(); // works fine
System.out.println(r.computeArea()); // Can't print void method, compile error
r = null; // Works fine
rar[1] = new Rectangle(); // Runtime ArrayIndexOutOfBoundsException, your array size is 1
System.out.println(Rectangle.name); // Works fine