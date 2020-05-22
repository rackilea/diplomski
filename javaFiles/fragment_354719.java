// indices are zero based

#define largestzfinder(_x_) largestzfinderfunc((_x_), sizeof(_x_) / sizeof(*_x_), (_x_)[0] + (_x_)[1], 1, 0)

unsigned int largestzfinderfunc( unsigned int set[], size_t size, unsigned int partialsumsofar, unsigned int i, unsigned int largestsofar ){
    unsigned int j;
    if ( i < size - 1 && ( j = largestzfinderfunc( set, size, partialsumsofar + set[i + 1], i + 1, ( set[i + 1] > largestsofar ) ? set[i + 1] : largestsofar ) ) ){
        return j;
    }
    else if ( 2 * largestsofar <= partialsumsofar ) {
        return i;
    }
    else
        return 0;
}