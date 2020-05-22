// Give the method an operator argument 
public void doSomething(BinaryOperator<Integer> otherMethod) {
    int a = 6;
    int b = 7;

    // Then use it here basically like before
    // "apply" is needed to call the passed function
    int c = otherMethod.apply(a,b);
    while(c < 50) 
        c++;
    }
}