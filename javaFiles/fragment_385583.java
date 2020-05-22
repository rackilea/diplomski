// Executes z = x*3, setting z to 6 (as you expect)
Whatever foo = new Whatever();
System.out.println(foo.z); //prints 6

// Sets x to 10 (remember, x is static, you only have one of them!)
Whatever.x = 10;
System.out.println(foo.x); // prints 10

// Because since the last time you've created a Whatever, 
// nothing has changed z!
System.out.println(foo.z); // prints 6 WHY?!?!

// Now you've created a new Whatever, and z = x*3 gets executed
// in the constructor again
Whatever bar = new Whatever();


System.out.println(bar.z); // prints 30 as expected