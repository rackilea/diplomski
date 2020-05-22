private Fibonacci_Recursive(int n) {
    ...
    for (int i = 0; i < finalResult.length; i++) {
        //Replaced st = finalResult[i] + st by
        st = st + finalResult[i];
    }
    ...
}