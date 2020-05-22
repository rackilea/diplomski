// version 0
class A {
    Object o = new Object();
}

// version 1
class A {
    // This will ensure o will not be be read, or be written into file. 
    // transient keyword which prevent read, will only work well for xstream 1.3.1
    transient Object o = new Object();
}

// version 2. Slowly phase out Object o, after class A had been deployed for quite sometime.
class A {
}