SomeClass sc = // may be null
   try {
       sc.someMethod();
   } catch (NullPointerException ex) {
       // We don't know for sure if 'sc' was null, or if the NPE
       // happened within the `someMethod()` call.
   }