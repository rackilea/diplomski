// indices are zero based

#define largestzfinder(_x_) largestzfinderfunc((_x_), sizeof(_x_) / sizeof(*_x_))

unsigned int largestzfinderfunc( unsigned int set[], size_t size ) {

    unsigned int largestz = 0;
    unsigned int partialsumsofar = 0;
    int disqualified;

    for ( int i = 0; i < size; i++ ){
        partialsumsofar += set[i];

        disqualified = 0;
        for ( int j = 2; j <= i; j++ ) {    // for all j from 2 to i (inclusive)
            if ( 2 * set[j] > partialsumsofar ) {
                disqualified = 1;
                break;
            }
        }

        if ( !disqualified )    // if comparison held for all j
            largestz = i;
    }

    return largestz;
}