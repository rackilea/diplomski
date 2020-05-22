// A method that changes the first entry in an array
void changeArray(String[] theArray) {
    theArray[0] = "Updated";
}

// A method that uses the above
void someMethod() {
    String[] foo = new String[3];
    foo[0] = "Original 0";
    foo[1] = "Original 1";
    foo[2] = "Original 2";

    this.changeArray(foo); // `changeArray` receives a *copy* of the reference
                           // held in `foo`; both references point to the same
                           // array

    System.out.println(foo[0]); // Prints "Updated"
}