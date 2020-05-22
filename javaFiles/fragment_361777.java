double a = 10.0, b = 5.0;

// wrong
if( a.compareTo(b) > 0 ) { /* ... */ }
// instead you can simply do this:
if( a >= b) { /* ... */ }

int a = 0;
double b = 10.0;

// wrong
a = b.intValue();
// perform the cast directly.
a = (int)b;