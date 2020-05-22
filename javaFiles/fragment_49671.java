// Get field, named obj1, from class Something.
Field f = Something.class.getDeclaredField("obj1");
// This line allows you access the value of an inaccessible (non-public) field.
f.setAccessible(true);
// Assigning the value of the field, named obj1, to obj.
// You may want to cast to a more concrete type, if you know exactly what is stored in obj1.
// The parameter for get() is ignored for static fields, so simply pass null.
Object obj = f.get(null);

// Now you can do whatever you want with obj, 
// which refers to the same object as static field obj1 of Something.
System.out.println(obj);