public static byte[] addOne(byte[] A) {
    int lastPosition = A.length - 1; 

    // Looping from right to left
    for (int i = lastPostion; i >= 0; i--) {
        if (A[i] == 0) {
            A[i] = 1; // If current digit is 0 I change it to 1
            return A; // I can exit because I have no reminder
        }
        A[i] = 0;     // If current digit is 1 I change it to 0 
                      // and go to the next position (one position left)
    }
    return A;         // I return the modified array
}