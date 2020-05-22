public static void main(String[] args) {

    // Our new ArrayList to hold our objects!
    ArrayList<Object> stuff = new ArrayList<Object>();

    int i = 0;
    while (i < 5) {
        Object obj = new Object(); // Create an object and make obj point to it.
        stuff.add(obj); // Put "the object that 'obj' points to" in 'stuff'.
        i++;
    }

    // This loop goes through all of the Objects in the ArrayList and prints them
    for (int index = 0; index < stuff.size(); index++) {
        System.out.println(stuff.get(i)); // This will print a single 
                                          // object in the ArrayList each time.
    }
}