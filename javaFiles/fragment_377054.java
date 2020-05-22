FindMin(F, lo, hi){
    if(lo==hi) return F[lo];
    int mid = lo + (hi-lo)/2 // Actually you can change this into (lo+hi)/2
    if(F[mid] > F[mid+1]) return FindMin(F, mid+1, hi) // Change the comparison and recursive call!
    if(F[mid] > F[mid-1]) return FindMin(F, lo, mid-1) // Change the comparison and recursive call!
    // If we reach here, that means F[mid-1] > F[mid] < F[mid+1]
    return F[mid]
}