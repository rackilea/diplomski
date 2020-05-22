float processOneValue( float in ) {
    // calculate new output:
    double out = in * b[0] ;
    for( int i=0; i<9; ++i )
       out += x[i]*b[i+1] ;
    for( int i=0; i<9; ++i )
       out -= y[i]*a[i+1] ;

    // update:
    for( int i=9; i>=1; --i )
       y[i] = y[i-1];
    y[0] = out;

    for( int i=9; i>=1; --i )
       x[i] = x[i-1];
    x[0] = in;

    return out;
}