public static void quicksort( Comparable [ ] a ) {

quicksort( a, 0, a.length - 1 );
}
private static final int CUTOFF = 10;
private static void quicksort( Comparable [ ] a, int low, int high ) {
if( low + CUTOFF > high )
insertionSort( a, low, high );
else {
int middle = ( low + high ) / 2;
if( a[ middle ].compareTo( a[ low ] ) < 0 )
swapReferences( a, low, middle );
if( a[ high ].compareTo( a[ low ] ) < 0 )
swapReferences( a, low, high );
if( a[ high ].compareTo( a[ middle ] ) < 0 )
swapReferences( a, middle, high );
swapReferences( a, middle, high - 1 );
Comparable pivot = a[ high - 1 ];
int i, j;
for( i = low, j = high - 1; ; ) {
while( a[ ++i ].compareTo( pivot ) < 0 )
;
while( pivot.compareTo( a[ --j ] ) < 0 )
;
if( i >= j )
break;
swapReferences( a, i, j );
}
swapReferences( a, i, high - 1
quicksort( a, low, i - 1 ); // Sort small elements
quicksort( a, i + 1, high ); // Sort large elements
 }
}
public static final void swapReferences( Object [ ] a, int index1, int index2 )
{
Object tmp = a[ index1 ];
a[ index1 ] = a[ index2 ];
a[ index2 ] = tmp;
}
private static void insertionSort( Comparable [ ] a, int low, int high ) {
for( int p = low + 1; p <= high; p++ ) {
Comparable tmp = a[ p ];
int j;
for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
a[ j ] = a[ j - 1 ];
a[ j ] = tmp;
}
}