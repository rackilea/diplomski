public synchronized boolean print(Client c, Something something) {
    if(isFair(c) && isAvailable()) {
        requestToPrint(something);
    }
    else {
        // queue
        // Not sure what "requestToPrintNext" does, 
        // as it has no argument, like "something"
    }
}