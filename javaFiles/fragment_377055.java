FindMin(F, lo, hi){
    if(lo==hi) return F[lo];                           // Line 1
    int mid = (lo+hi)/2                                // Line 2
    if(F[mid] > F[mid+1]) return FindMin(F, mid+1, hi) // Line 3
    else return FindMin(F, lo, mid)                    // Line 4
}