public ResultType calcFoo( int i, double d ) {
    return calc( i, d, false );
}

public ResultType calcFoo( int i, double d, boolean flag ) {
    if( flag ) {
        ...
        return result;
    }
    else {
        ...
        return result;
    }
}