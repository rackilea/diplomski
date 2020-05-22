public callDoSomething(HasOperator obj) {
    // There may be a better way than having a "HasOperator" interface
    // This is just an example though
    BinaryOperator<Integer> f = obj.getOperator();

    doSomething(f);
}