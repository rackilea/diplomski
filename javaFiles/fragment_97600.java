if (next == 'V') {
    sum += 4;
    i++;
} else if (next == 'X') {  // note the else here...
    sum += 9;
    i++;
} else {
    sum += 1;
}