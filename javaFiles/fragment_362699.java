int[] arr = {9,12,13,11,10};
    BitSet numbers = new BitSet(101);
    for (int no : arr) {
        numbers.set(no);
    }
    int sequenceCount = 0;
    int last = -10;
    for (int i = numbers.nextSetBit(0); i >= 0; i = numbers.nextSetBit(i+1)) {
        if (sequenceCount == 0 || i - last > 1) {
            sequenceCount = 1;
        } else {
            sequenceCount++;
            if (sequenceCount >= 3) {
                System.out.println("Sequence start: " + (last - 1));
                break;
            }
        }
        last = i;
    }
    System.out.println("Done");