public void testNull() {
   try {
       obj.setFoo(null);
       fail("IllegalArgumentException is expected");
   } catch (IllegalArgumentException e) {
       // OK
   }
}