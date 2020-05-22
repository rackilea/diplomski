try {
   doSomething(); // can throw SomeException 
   doAnotherThing(); 
   doSomething(); // can throw SomeException as well  
   return someResult; 
} catch(SomeException e) {
   throw new AnotherException(e);
}