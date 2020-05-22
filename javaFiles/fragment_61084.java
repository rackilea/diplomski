private Type func(Type accumulator, List input) {
    if(input.size() == 0) {
        return accumulator;
    } else {
        Type myAccumulated = someOperation(accumulator, input.head());
        return func(myAccumulated, input.tail();
    }
}