int initialLen = storelab[0].length;

// Iterate from index 1, as we already got 0
for (int i = 1; i < contalinhas; i++) {
    int currLen = storelab[i].length;
    if (initialLen != currLen) {
        throw new SomeException();
    }
}