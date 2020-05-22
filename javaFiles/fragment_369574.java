try {
    // do something that may fail
    return 0; // return a normal value
} catch(SomeException e) {
    // maybe log an error
    return -1 // maybe return a default or error value
} finally {
    // maybe clean up resources
    // finally will be executed even if you return in try or catch
    // a return here will trump a return in try/catch. This is generally regarded as a bad idea
    // see https://stackoverflow.com/questions/65035/does-finally-always-execute-in-java
}
return 1 // return a normal value here instead of in the try/catch.
// May be clearer than multiple return statements  
// Also useful if return value does not depend on the try/catch outcome