// Let's say this is an instance of our class
Something sth = new Something();
// ...

// Get field, named obj1, from class Something.
Field f = Something.class.getDeclaredField("obj1");
// This line allows you access the value of an inaccessible (non-public) field.
f.setAccessible(true);
// Assigning the value of the field, named obj1, to obj.
// You may want to cast to a more concrete type, if you know exactly what is stored in obj1.
// The parameter for get() is the instance of Something, 
// for which you want to retrieve the value of an instance field, named obj1.
Object obj = f.get(sth);

// Now you can do whatever you want with obj,
// which refers to the same object as instance field obj1 of sth.
System.out.println(obj);