// This will work!
// Determine if the absolute values of two objects are the same.
boolean absEqual(NumericFns<? extends Number> ob) {
    if( Math.abs(num.doubleValue()) ==
            Math.abs(ob.num.doubleValue()) ) return true;
    return false;
}