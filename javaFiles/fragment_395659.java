// outer loop
    for (int i = 0; i < A.length; i++) {
        int count = 0;

        // inner loop
        for (int j = 0; j < B.length; j++) {
            if (A[i] == B[j])
                count++;
        }
        if (count == 1)
            L.add(A[i]);
    }