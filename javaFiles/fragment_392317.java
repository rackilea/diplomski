Object o; // <-- a simple container
new Object(); // <-- a object stored in memory in all it's glory

Object o = new Object(); // <-- container o is now pointing to the memory address of new Object()

Object o = new Object(); // container 0 is now pointing to a different object in memory
//But the old one is still chilling at it's own address and needs to be collected