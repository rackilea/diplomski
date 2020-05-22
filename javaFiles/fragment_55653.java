if (digits[i] == '1' || digits[i] == '2' || digits[i] == '3' || digits[i] == '5' || digits[i] == '7') {
    noHoles++;
} else if (digits[i] == '4' || digits[i] == '6' || digits[i] == '9' || digits[i] == '0') {
    oneHole += 1;
} else if (digits[i] == '8') {
    twoHoles += 2;
}