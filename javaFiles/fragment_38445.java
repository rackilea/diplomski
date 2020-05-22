// Objects supplied to comparing function
Vector a = ..
Vector b = ..

// First component in which the values are not equals
// establishes a 'winner'
int cmp = 0;
if ((cmp = compareTo(a.v1, b.v1)) != 0) return cmp;
if ((cmp = compareTo(a.v2, b.v2)) != 0) return cmp;
if ((cmp = compareTo(a.v3, b.v3)) != 0) return cmp;
return 0;