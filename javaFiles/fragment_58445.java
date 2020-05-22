public class Subclass2 extends Superclass<Subclass2> {
  ...
}

Subclass sub = new Subclass();
Subclass2 sub2 = new Subclass2(); // the superclass portions of the two objects
                                  // are identical

sub2.compareTo(sub); // what should be the result?