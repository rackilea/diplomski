// A = array, n = size of array, i = looking at now
private static boolean symmHelper(int[] A, int n, int i) {

    if (i > n/2)     // If we're more than halfway without returning false yet, we win
        return true;

    else if (A[i] != A[n-1-i])    // If these two don't match, we lose
        return false;

    else    // If neither of those are the case, try again
        return symmHelper(A, n, i+1);
}