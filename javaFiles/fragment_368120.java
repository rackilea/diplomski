try {
    // code here
    if(needToThrow) {
        throw new GraphicsFileNotFoundException();
    }
}
catch(GraphicsFileNotFoundException e) {
    // handle the error (print stack trace or error message for example)
    e.printStackTrace(); // this is printing the stack trace
}