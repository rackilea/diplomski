try {
    // TODO: write your setup code here

    boolean hasNext = false;
    try {
        hasNext = rest.next();
    }catch (Exception e) {
        // TODO: log exception, increase a counter
    }
    while(hasNext){
        try {
            // TODO: write your processing code here

        }catch (Exception e) {
            // TODO: log exception, increase a counter
        }
        try {
            hasNext = rest.next();
        }catch (Exception e) {
            // TODO: log exception, increase a counter
            hasNext = false; //prevent infinite loops
        }
    }
} catch (Exception e){
    // TODO: this should never happen, handle ClassNotFoundException etc.
}