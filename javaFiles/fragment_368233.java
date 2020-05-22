public Object fooInt() {
    return 5;
}
public Object fooInteger() {
    return new Integer(5);
}

Integer integerResult = (Integer)fooInteger(); //No cost
integerResult = (Integer)fooInt(); //Small casting cost

int intResult = (int)fooInteger(); //Small casting cost
intResult = (int)fooInt(); //No cost