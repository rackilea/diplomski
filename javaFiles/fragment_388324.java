public static byte[] addOne(byte[] A) throws Exception {
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                A[i] = 1;
                return A;
            }
            A[i] = 0;
            if (i == 0) {
                throw new Exception("Overflow");
            }
        }
        return A;
    }