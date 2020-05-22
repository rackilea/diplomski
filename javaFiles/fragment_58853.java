static String str; // In Java str is a reference.

static void setS() {
    String x = "Hello";
    str = x;  // x and str are references to an object on the heap so no problem.
    // if str was now a reference to an object on the stack, 
    // you could have a corruption issue.
}