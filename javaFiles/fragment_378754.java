for (n = 0; n < a.length; n++) { // loop a.length times; not totalOdds
    x = (a[n] % 2);
    if (x == 1) { // ADDED
        odds[y] = a[n];
        y++; // increment only when an odd is found
    } // ADDED
}