void syntheticExample(int[] these, int[] those, int[] theOthers) {
    int[] numbers;

    // ...some work...

    if (/*...some condition...*/) {
        numbers = these;
    } else {
        // ...more work, then:
        if (/*...some other condition...*/) {
            numbers = those;
        } else if (/*...some further condition...*/) {
            numbers = theOthers;
        } else {
            // We'll use our own numbers
            numbers = new int[] {1, 2, 3};
        }
    }

    // ...use `numbers`...
}