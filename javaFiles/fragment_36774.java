/* this is valid since compiler knows myBar
belongs to an instance of Foo called f */
Foo f = new Foo();
f.changeIt(f.myBar);  

/* This is invalid because compiler doesn't know which
myBar this is since it isn't connected to a class */
Foo f = new Foo();
f.changeIt(myBar);