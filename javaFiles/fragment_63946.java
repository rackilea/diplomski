bool success = false;
try {
    //your code
    success = true;
    return retVal;
} finally {
    if (!success) {
        //clean up
    }
}