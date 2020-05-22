UnaryOperator uop = new UnaryOperator(...);
AbstractOperator aop = uop;

...

// This will call the "unary" version of the method
processOperator(uop);

// This will call the "abstract" version of the method
processOperator(aop);