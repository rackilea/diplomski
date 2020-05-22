do {
    int digit = num % 10;

    if ( digit == 0 ) {
        zero_count ++;
    } else if ( digit % 2 == 0 ) {
        even_count ++;
    } else {
        odd_count ++;
    }

    num /= 10;

} while ( num > 0 );