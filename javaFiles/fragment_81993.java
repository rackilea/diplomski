public class Foo { }
public class Bar extends Foo { }

//...
Foo foo = new Bar();
System.out.println(foo instanceof Bar); //prints true
System.out.println(foo instanceof Foo); //prints true
Foo foo2 = new Foo();
System.out.println(foo.getClass() == foo2.getClass()); //prints false