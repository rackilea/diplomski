boolean someMethod() {
  if ( something ) {
    // ...
    return true;
  }
  // if something was true then the next piece of code will never get executed
  // if was not true then the next piece of code will always execute

  // ...
  return false;
}