static void doSomething(int mask) { // the method
   if (State.A.isPartOf(mask)) {
     // we got A
   }
   else <... etc. ...>
}

static {
  doSomething(State.A.mask() | State.C.mask());
}