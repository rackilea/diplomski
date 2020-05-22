public static int[] stringToBigInt(String s) {
        int []A = new int [SIZE];

        int j = s.length() - 1;
        for (int i = A.length - 1; j >= 0 && i >= 0; --i){
            A[i] = s.charAt(j) - '0';
            --j;
        }

        return A;   
    }