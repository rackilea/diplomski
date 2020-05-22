private static int factorial(int value){
    if (value == 1){
        return 1;
    }
    int recursiveResult = factorial(value - 1);
    return recursiveResult * value;
}