public boolean timeStringLen(int reps){
    boolean result = false;

    for(int i = 0; i<reps; i ++){
        result ^= mdnCheckRegularMethod(mdn[index]);
    }
    return result;
}