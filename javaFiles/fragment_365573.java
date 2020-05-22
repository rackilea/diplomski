public void bar() {
  Object x = null; // this is OK
  x = new Object();
   // big, complex piece of code here
  x = null; // this is not required
   // big, complex piece of code here
}