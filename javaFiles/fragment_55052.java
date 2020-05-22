public static double mode(double[] a) {

    double currentBestCandidate = a[0];
    int countCurrentBestCandidate = BasicMathMethods.getTotal(a, 0);

    // we already have index 0, lets start from 1
    for(int element = 1; element < a.length; element++) {
        int count = BasicMathMethods.getTotal(a, element);

        // if this count is greater than what we have 
        // right now, we need to update currentBestCandidate 
        // and countCurrentBestCandidate
        if(count > countCurrentBestCandidate) {
            currentBestCandidate = a[element];
            countCurrentBestCandidate = count;
        }
    }
    return currentBestCandidate;
}