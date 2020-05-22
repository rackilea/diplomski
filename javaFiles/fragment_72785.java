long i = 2; // start with 2, not 1
    while (i < number) { // and don't end with the number itself
        if (number % i == 0) {
            factor += i+", "; // add i, not x; and add it to factor, not to number
            number /= i;
        } else {
            i++;
        }
    }
    return factor; // return factor, not number