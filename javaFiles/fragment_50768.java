// If you can, pass a parameter of type T :
private <T> void doStuff(T something) {

   ArrayList<T> = new ArrayList<T>();
   ... rest of logic
}
// so it can be called like that :  
YourType param = ...;
foo.doStuff(param);

// If you can't pass a parameter of type T, you'll have
// to explicitly tell the compiler which type to use :
foo.<YourType>doStuff();