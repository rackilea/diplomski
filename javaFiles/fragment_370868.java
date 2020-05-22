public Polynomial(String p) {
    // First step is to create a scanner of the String
    // passed into the constructor.
    Scanner scanner = new Scanner(p);

    // Next step is to initialize the String poly
    // to an empty String so we can append to it.
    poly = "";

    // Next we need to include a way of keeping track of
    // whether the value we just read was a first or second
    // member of a pair. We can do that with a boolean
    // initialized to false since the first use will be
    // when it is on the first of a pair.
    boolean isOnSecond = false;

    // Now we need to start looping through the values in
    // p which are separated by white space. Scanner has
    // a method for that, scanner.next().
    while(scanner.hasNext()) {
        String currentValue = scanner.next();

        // Now is where the boolean comes into play.
        if(isOnSecond) { // second of a pair
            // the second of a pair needs to have "x^" before its value
            poly = poly + "x^" + currentValue;

            // Here we need to check if there is another value coming after
            // and if there is append a " + " to poly
            if(scanner.hasNext() {
                poly = poly + " + ";
            }
        }
        else { // !isOnSecond, so is first of a pair
            // Only need to append the currentValue here
            poly = poly + currentValue;
        }
        isOnSecond = !isOnSecond; // toggles isOnSecond
    }
}