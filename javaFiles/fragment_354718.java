// indices are zero based

#define largestzfinder(_x_) largestzfinderfunc((_x_), sizeof(_x_) / sizeof(*_x_))

unsigned int largestzfinderfunc( unsigned int set[], size_t size ) {

    unsigned int largestz = 0;
    unsigned int partialsumsofar = 0;
    unsigned int * largestsofar = calloc( size, sizeof * largestsofar );

    for ( int i = 0; i < size; i++ )
        partialsumsofar += set[i];

    largestsofar[0] = 0;
    largestsofar[1] = 0;
    largestsofar[2] = set[2];
    for ( int i = 3; i < size; i++ )
        largestsofar[i] = (set[i] > largestsofar[i-1]) ? set[i] : largestsofar[i-1];

    for ( int i = size - 1; i >= 0; i-- ){

        if ( 2 * largestsofar[i] <= partialsumsofar ) {
            largestz = i;
            break;
        }

        partialsumsofar -= set[i];
    }

    free( largestsofar );

    return largestz;
}