private int chooseBin(float[] freq, float fsum) {
// given an array of frequencies (probabilities) freq
// and the sum of this array, fsum
// choose a random number between 0 and 90
// such that if this function is called many times
// the frequency with which each value is observed converges
// on the frequencies in freq
    float x, cs=0; // x stores random value, cs is cumulative sum
    int ii=-1;     // variable that increments until random value is found

    x = Math.rand();

    while(cs < x*fsum && ii<90) { 
    // increment cumulative sum until it's bigger than fraction x of sum
        ii++;
        cs += freq[ii];
    }
return ii;
}