Number left = (Number)args.get(0);  // not sure if casting is necessary here
Number right = (Number)args.get(1); // since I don't know the type of your list
if (left instanceof Integer && right instanceof Integer) {
    // if both operands are Integer, return an Integer
    return left.intValue() + right.intValue();
} else {
    // if any of the operands is Double, the result must be Double
    return left.doubleValue() + right.doubleValue();
}