public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 2, 3}; // 2, 3 repeats at position 2.

    // for every position in the array:
    for (int startPos = 0; startPos < arr.length; startPos++) {
        // check if there is a repeating sequence here:

        // check every sequence length which is lower or equal to half the
        // remaining array length: (this is important, otherwise we'll go out of bounds)
        for (int sequenceLength = 1; sequenceLength <= (arr.length - startPos) / 2; sequenceLength++) {

            // check if the sequences of length sequenceLength which start
            // at startPos and (startPos + sequenceLength (the one
            // immediately following it)) are equal:
            boolean sequencesAreEqual = true;
            for (int i = 0; i < sequenceLength; i++) {
                if (arr[startPos + i] != arr[startPos + sequenceLength + i]) {
                    sequencesAreEqual = false;
                    break;
                }
            }
            if (sequencesAreEqual) {
                System.out.println("Found repeating sequence at pos " + startPos);
            }
        }
    }
}