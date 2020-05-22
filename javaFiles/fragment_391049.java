public static boolean areValuesValid( double [] values, int numElements ) {
    return areValuesValid(values, numElements, i -> !Double.isNaN(values[i]));
}

public static boolean areValuesValid( float[] values, int numElements ) {
    return areValuesValid(values, numElements, i -> !Float.isNaN(values[i]));
}

private static boolean areValuesValid( Object values, int numElements, IntPredicate tester ) {
    if( values == null || Array.getLength(values) != numElements ) {
        return false;
    }
    for( int i = 0; i < numElements; ++i ) {
        if( !tester.test(i) ) {
            return false;
        }
    }
    return true;
}