// Signature changes to include any exceptions that really can be thrown
public void foo() throws XYZException, ABCException {
 // A flag indicating that the commit succeeded
 boolean done = false;

 begin();
 try {
  // Don't have any `return` statements in here (or if you do,
  // set `done` to `true` first)

  ...
  commit();
  done = true; // Commit didn't throw an exception, we're done
 } finally {
  // finally clause always happens regardless
  if (!done) {
    // We must be processing an exception; rollback
    try {
      rollback();
    } catch (Exception e) {
      // quash it (e.g., leave this block empty), we don't want
      // to mask the real exception by throwing a different one
    }
  }
 }
}