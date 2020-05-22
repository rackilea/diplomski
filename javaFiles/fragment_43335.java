// increment the counters
counters[0]++;
for (int i = 0; i < counters.length; i++) {
    String[] combosForCurrentDigit = dialPad[numberAsDigits[i]];
    if (counters[i] == combosForCurrentDigit.length) {
        counters[i] = 0;
        if (i + 1 == counters.length) {
            finished = true;
        } else {
            counters[i + 1]++;
        }
    }
}