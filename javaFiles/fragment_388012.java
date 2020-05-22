Object[] array = new Object[5];
Object object = new Object() // 1 reference
array[3] = object; // 2 references
array[1] = object; // 3 references


object = null; // 2 references
array[1] = null; // 1 references
array[3] = new Object(); // 0 references -> eligible for garbage collection

array = null; // now even the array is eligible for garbage collection
// all the objects stored are eligible too at this point if they're not
// referenced anywhere else