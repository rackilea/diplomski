boolean error = false;
if(childCount >= CHILD_LIMIT) {
    System.out.println("You have reached child capacity");
    error = true;
}
if(adultCount >= ADULT_LIMIT) {
    System.out.println("You have reached adult capacity");
    error = true;
}
...
if(error) {
    /* error occurred, don't process input normally */
}