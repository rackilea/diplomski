Exception error = null;
try {
 // do something
}
catch (Exception e) {
  error = e;
}
// My finally code goes here
// ...
if (error != null) {
  // Oh dear clean up all my resources - files, windows, sockets etc.
  throw error;
}