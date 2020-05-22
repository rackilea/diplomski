Thread one = ...;
one.start();
one.join(5000);
if (one.isAlive()) {
  //clearly, the Thread is not dead
}