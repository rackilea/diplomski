import java.util.HashSet;

class Pairs {
    public static void main(String[] args) {
        Integer[] A = new Integer[]{1,2,3};
        Integer[] B = new Integer[]{3,4,5};
        Integer[] C = new Integer[]{1,4,7};

        HashSet<Integer> c = new HashSet<Integer>();
        for (int i = 0; i < C.length; i++) {
            c.add(C[i]);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (c.contains(A[i] + B[j])) {
                    System.out.format("%d %d %d%n", A[i], B[j], A[i]+B[j]);
                }
            }
        }
    }
}