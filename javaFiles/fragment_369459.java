c.print(p);
//Compiler resolves that `print(Parent)` method should be called.
//Runtime resolves that child objects method should be called.
//Prints "I am Child class' parent print method "

c.print(c);
//Compiler resolves that `print(Child)` method should be called.
//Runtime resolves that child objects method should be called.
//Prints "I am Child class' child print method "

c.print(pc);
//Compiler resolves that `print(Parent)` method should be called.
//Runtime resolves that child objects method should be called.
//Prints "I am Child class' parent print method "

pc.print(p);
//Compiler resolves that `print(Parent)` method should be called.
//Runtime resolves that child objects method should be called.
//Prints "I am Child class' parent print method "

pc.print(c); //PAY ATTENTION TO THIS...
//Compiler resolves that `print(Parent)` method should be called.
// This is because PC is Parent type reference and compiler doesn't find `print(Child)` in Parent class, so it uses `print(Parent)`.
//Runtime resolves that child objects method should be called.
//Prints "I am Child class' parent print method "

pc.print(pc);
//Compiler resolves that `print(Parent)` method should be called.
// This is because Compiler knows only about the variable's reference type (And PC is of type Parent). Hence `print(Parent)` would be chosen.
//Runtime resolves that child objects method should be called.
//During runtime, the type of the actual object is used. And PC is referring to an Child object... So `pc.print(...)` will call the child's method.
//Prints "I am Child class' parent print method "