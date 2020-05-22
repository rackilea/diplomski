Object[] a = new Object[4]; // array whose element type is Object
// element 0 is a reference to a String (which is a subclass of Object)
a[0] = "foo";

// element 1 is a reference to a Double (which is a subclass of Object)
a[1] = 123.45;

// element 2 is the value null (no object! although null is still assignable to Object type)
a[2] = null;

// element 3 is a reference to another array (all arrays classes are subclasses of Object)
a[3] = new int[] { 2, 3, 5, 7, 11 };