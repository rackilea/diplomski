public static void main(String[] args) {

    Object o;
    int i = 0;
    while (i < 5) {
        Object reference = new Object(); // Create a new Object and store 
                                         // it in 'reference'
        o = obj; // The Object 'o' now refers to the object in 'reference'
        i++;
    }
    System.out.println(o); // This should print information about the 
                           // LAST object created.
}