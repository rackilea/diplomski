// Again, won't work.  T is only declaring the type inside your class/method.
// When using it to declare a variable, you have to say EXACTLY what you're making,
// or at least something as exact as the methods you're trying to invoke
EnitityA<T extends AssocA> myEntity = new EntityA<AssocAConcrete>();

//Instead do this...
EnitityA<AssocAConcrete> myEntity = new EntityAConcrete();

// Or this...
EntityAConcrete myEntity = new EntityAConcrete();