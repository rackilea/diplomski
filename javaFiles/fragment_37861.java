{
  BigObject obj = ...
  doSomethingWith(obj);
  obj = null;             <-- explicitly set to null
  doSomethingElse();
}