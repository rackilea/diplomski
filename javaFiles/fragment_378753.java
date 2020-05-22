if ((x == 0)) // ^ (x == 2)) <-- remove this ^ condition
    totalEvens += 1;

for (n = 0; n < a.length; n++) { // loop a.length times; not totalEvens
    x = (a[n] % 2);
    if (x == 0) { // ADDED
        evens[y] = a[n];
        y++; // increment only when an even is found
    } // ADDED
}