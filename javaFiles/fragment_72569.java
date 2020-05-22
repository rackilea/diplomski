A a = new A();
a.start();
a.join(); // Will wait until thread A is done

B b = new B();
b.start();
b.join(); // Will wait until thread B is done