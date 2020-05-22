public Polynomial(Polynomial poly)
{
    int aLen = poly.a.length;
    int bLen = poly.b.length;

    // Initialize arrays for this object
    a = new int[aLen];  // Assuming `a` and `b` are integer arrays
    b = new int[bLen];  // Change accordingly.

    // A better way to create copy of arrays would be to use `System.arraycopy
    System.arraycopy( poly.a, 0, a, 0, aLen);
    System.arraycopy( poly.b, 0, b, 0, bLen);


    /*** You can avoid using below loops ***/

    // Iterate till the `aLen` of `poly` object passed 
    // and add elements to `a` array of this object
    /*for(int i = 0; i < aLen; i++)
        a[i] = poly.a[i];

    // Iterate till the `bLen` of `poly` object passed 
    // and add elements to `b` array of this object
    for(int i = 0; i < bLen; i++)
        b[i] = poly.b[i]; */
}