loopCount = 0;
for (int i=1; i<n; i++) {
    if (Index[i] > Index[i+1]) {
        loopCount++;
    }
}