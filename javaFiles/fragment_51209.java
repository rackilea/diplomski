try {
  ...
} catch ( IOException e ) {
  if ( this.isCancelled() ) {
    // May ignore the exception. We're terminating anyway.
  } else {
    throw e; // Not cancelled -> Need to propagate the exception.
  }
}