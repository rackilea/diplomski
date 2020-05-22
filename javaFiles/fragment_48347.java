public void someMethod() {
    InputStream stream = ...
    try {
         // process the stream here probably by calling other methods
    } finally {
         // stream should be closed in the same method for parity
         stream.close();
    }
 }