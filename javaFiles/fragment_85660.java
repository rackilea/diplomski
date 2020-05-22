int rFunction(int a) {
    // if we found our needed value, return it
    if(a == 10) {
        return a;
    }

    a = whatever();

    rFunction(a); // call again with new value   
}