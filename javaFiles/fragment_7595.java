Vector v1 = new Vector(); // Creates a new Vector (I call it vFirst) and assign it to v1
Vector v2 = new Vector(); // Creates a new Vector (I call it vSecond) and assign it to v2
v1 = null;        // Now vFirst is not referenced by any variable so is candidate to be gc
Vector v3 = v1;   // Assign a null value to v3
v1 = v2;          // Assign to v1 the vector vSecond
v1.addElement(v2); // Add to the vSecond the element vSecond