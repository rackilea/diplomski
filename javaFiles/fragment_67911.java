try {
    // TODO: write your setup code here

    while(true){
        try {
            if(!rest.next()){
                break;
            }
        }catch (Exception e) {
            // TODO: log exception, increase a counter
            break;
        }
        try {
            // TODO: write your processing code here

        }catch (Exception e) {
            // TODO: log exception, increase a counter
        }
    }
} catch (Exception e){
    // TODO: this should never happen, handle ClassNotFoundException etc.
}