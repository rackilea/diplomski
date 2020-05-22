public static byte[] addOne(byte[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                A[i] = 1;
                return A;
            }
            A[i] = 0;
            if (i == 0) {
                A = new byte[A.length + 1];
                Arrays.fill(A, (byte) 0); // Added cast to byte
                A[0] = 1;
            }
        }
        return A;
    }