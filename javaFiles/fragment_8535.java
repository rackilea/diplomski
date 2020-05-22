MyContext.enter();
try {
   // connections are available here:
   // anything that calls MyContext.get()
   // gets (the same) valid connection instance
} finally {
  MyContext.exit();
}