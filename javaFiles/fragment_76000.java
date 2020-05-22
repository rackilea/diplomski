StringBuilder builder = new StringBuilder("");
try {
    builder.append("Rohit ");
    return builder;

} finally {
    // Here you are changing the object pointed to by the reference
    builder.append("Jain");  // Return value will be `Rohit Jain`

    // However this will not nullify the return value. 
    // The value returned will still be `Rohit Jain`
    builder =  null;
}