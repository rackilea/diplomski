Integer[] ary = { 1, 2, 3 };
myObj.function(ary); // T is Integer
myObj.<Integer>function(ary); // T is Integer
myObj.<Integer[]>function(ary); // T is Integer[]


<Integer>function(ary); // this is invalid; instead you could do...
this.<Integer>function(ary); // this if it's an instance method
MyClass.<Integer>function(ary); // or this if it's static