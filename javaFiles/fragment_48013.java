public String[][] myMethod() {
    String[][] arr = new String[1][];
    try {
        arr = methodThatCanThrowException(); // If this method throws an exception
        return arr;                          // this return will not execute
    } catch (Exception ignored) {}

    return arr;                              // Return something after the try/catch block
}